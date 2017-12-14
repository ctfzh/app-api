package com.funbox.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.funbox.project.configurer.FunboxProperties;
import com.funbox.project.core.ProjectConstant;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.exception.PayException;
import com.funbox.project.exception.build.BaseExceptionBuild;
import com.funbox.project.model.AppOrderMain;
import com.funbox.project.model.AppZfCache;
import com.funbox.project.model.H5Order;
import com.funbox.project.model.MtVmChannelConfigInfo;
import com.funbox.project.service.H5OrderService;
import com.funbox.project.service.MtVmChannelConfigInfoService;
import com.funbox.project.service.WeiXinPayService;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.funbox.project.utils.HttpClientUtil;
import com.funbox.project.utils.PayForUtil;
import com.funbox.project.utils.XMLUtil;
import com.funbox.project.utils.redis.RedisClientTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;


/**
 * Created by zhao6 on 2017/11/10.
 */
@Service
public class WeiXinPayServiceImpl implements WeiXinPayService {

    @Resource
    private MtVmChannelConfigInfoService mtVmChannelConfigInfoService;

    @Resource
    private H5OrderService h5OrderService;

    @Autowired
    FunboxProperties funboxProperties;

    @Autowired
    RedisClientTemplate redisClientTemplate;

    private static Logger lg=Logger.getLogger(WeiXinPayServiceImpl.class);
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;

        /**
         * 获取微信支付的二维码地址
         * @return
         * @author chenp
         * @throws Exception
         */
        @Override
        @Transactional
        public  Result getCodeUrl(AppZfCache zfCache) {
            /**
             * 账号信息
             */
            String appid = funboxProperties.getAppid();//微信服务号的appid
            String mch_id = funboxProperties.getMch_id(); //微信支付商户号
            String key =funboxProperties.getKey(); // 微信支付的API密钥
            String notify_url = funboxProperties.getSdj_notify_url();//回调地址【注意，这里必须要使用外网的地址】
            String ufdoder_url=funboxProperties.getPay_url();//微信下单API地址
            String trade_type = "NATIVE"; //类型【网页扫码支付】

            /**
             * 时间字符串
             */
            String currTime = PayForUtil.getCurrTime();
            String strTime = currTime.substring(8, currTime.length());
            String strRandom = PayForUtil.buildRandom(4) + "";
            String nonce_str = strTime + strRandom;
            //根据售货机id和商品id查询有多少商品

            Condition condition = new Condition(MtVmChannelConfigInfo.class);
            condition.createCriteria().andCondition("inner_code = "+zfCache.getInnerCode()+" and mdse_id = "+zfCache.getMdseId());
            List<MtVmChannelConfigInfo> mtVmChannelConfigInfoList = mtVmChannelConfigInfoService.findByCondition(condition);

            if(mtVmChannelConfigInfoList.size()<=0){
                throw new PayException(BaseExceptionBuild.buildData(BaseExceptionBuild.PRODUCTS_SOLD_OUT_ERROR));
            }
            if(mtVmChannelConfigInfoList.get(0).getAppZfbPrice().compareTo(new BigDecimal("0"))<=0){
                throw new PayException(BaseExceptionBuild.buildData(BaseExceptionBuild.WRONG_PRODUCT_PRICE_ERROR));
            }

            String orderId = getNumberForPK();

            /**
             * 参数封装
             */
            SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
            packageParams.put("appid", appid);
            packageParams.put("mch_id", mch_id);
            packageParams.put("nonce_str", nonce_str);//随机字符串
            packageParams.put("body", mtVmChannelConfigInfoList.get(0).getMdseName());//支付的商品名称
            packageParams.put("out_trade_no", orderId);//商户订单号【备注：每次发起请求都需要随机的字符串，否则失败。】
            packageParams.put("total_fee",mtVmChannelConfigInfoList.get(0).getAppWxPrice().toString());//支付金额
//            packageParams.put("total_fee","1");//支付金额
            packageParams.put("spbill_create_ip", PayForUtil.localIp());//客户端主机
            packageParams.put("notify_url", notify_url);
            packageParams.put("trade_type", trade_type);
            packageParams.put("attach", zfCache.getInnerCode()+zfCache.getMdseId());//额外的参数【业务类型+会员ID+支付类型】


            String sign = PayForUtil.createSign("UTF-8", packageParams,key);  //获取签名
            packageParams.put("sign", sign);

            String requestXML = PayForUtil.getRequestXml(packageParams);//将请求参数转换成String类型
            lg.info("微信支付请求参数的报文"+requestXML);
            String resXml = HttpClientUtil.postData(ufdoder_url,requestXML);  //解析请求之后的xml参数并且转换成String类型
            Map map = null;
            try {
                map = XMLUtil.doXMLParse(resXml);
            } catch (JDOMException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            lg.info("微信支付响应参数的报文"+resXml);
            String urlCode = (String) map.get("code_url");
            String resultCode = (String)map.get("result_code");

            if(resultCode.equals("SUCCESS")){
               //保存H5订单
                H5Order h5Order = new H5Order();
                h5Order.setOrderId(orderId);
                h5Order.setOrderStatus(4);//支付完成
                h5Order.setPayType(3);//微信支付
                h5Order.setInnerCode(zfCache.getInnerCode());
                h5Order.setMdseId(zfCache.getMdseId());
                h5Order.setMdseName(mtVmChannelConfigInfoList.get(0).getMdseName());
                h5Order.setPrice(mtVmChannelConfigInfoList.get(0).getAppZfbPrice().intValue());
                redisClientTemplate.set(orderId,h5Order);
            }

            return ResultGenerator.genSuccessResult(urlCode);
        }

    /**
     * 微信下单
     * @param zfCache
     * @return
     */
    @Transactional
    public Result wxAddOrder(AppZfCache zfCache, String userAgent) {
        if(org.apache.commons.lang3.StringUtils.isBlank(zfCache.getInnerCode())||zfCache.getMdseId()==0){
            ResultGenerator.genFailResult("lack of parameter");
        }
        //微信支付
        if(userAgent.toLowerCase().contains("micromessenger")){
            zfCache.setPayType(3);
        }
        //支付宝支付
        if(userAgent.toLowerCase().contains("alipayclient")){
            zfCache.setPayType(2);
        }
//        if(!"2,3".contains(zfCache.getPayType().toString())){
//            ResultGenerator.genFailResult("only support WEIXIN or ALIPAY scan Qr code.");
//        }

        //根据售货机id和商品id查询有多少商品
        Condition condition = new Condition(MtVmChannelConfigInfo.class);
        condition.createCriteria().andCondition("inner_code = "+zfCache.getInnerCode()+" and mdse_id = "+zfCache.getMdseId());
        List<MtVmChannelConfigInfo> mtVmChannelConfigInfoList = mtVmChannelConfigInfoService.findByCondition(condition);

        if(mtVmChannelConfigInfoList.size()<=0){
            ResultGenerator.genFailResult("products all sold out");
        }
        if(mtVmChannelConfigInfoList.get(0).getAppZfbPrice().compareTo(new BigDecimal("0"))<=0){
            ResultGenerator.genFailResult("wrong product price.");
        }

        //保存H5订单
        H5Order h5Order = new H5Order();
        h5Order.setOrderId(getNumberForPK());
        h5Order.setOrderStatus(1);
        h5Order.setPayType(zfCache.getPayType());
        h5Order.setInnerCode(zfCache.getInnerCode());
        h5Order.setMdseId(zfCache.getMdseId());
        h5Order.setMdseName(mtVmChannelConfigInfoList.get(0).getMdseName());
        h5Order.setPrice(mtVmChannelConfigInfoList.get(0).getAppZfbPrice().intValue());
        BigDecimal time = new BigDecimal(System.currentTimeMillis()/1000L);
        h5Order.setCreated(time.intValue());
        h5OrderService.save(h5Order);

        return ResultGenerator.genSuccessResult("下单成功");
    }

    @Override
    public void notifyLyVs(String orderId){
        if(redisClientTemplate.get(orderId)==null){
            return;
        }

        H5Order h5Order = (H5Order)redisClientTemplate.get(orderId);

        Condition condition = new Condition(MtVmChannelConfigInfo.class);
        condition.createCriteria().andCondition("inner_code = "+h5Order.getInnerCode()+" and mdse_id = "+h5Order.getMdseId());
        List<MtVmChannelConfigInfo> mtVmChannelConfigInfoList = mtVmChannelConfigInfoService.findByCondition(condition);

        Condition condition1 = new Condition(H5Order.class);
        condition1.createCriteria().andCondition("order_id = "+orderId);
        List<H5Order> h5Order1 = h5OrderService.findByCondition(condition1);
        if(h5Order1!=null&&h5Order1.size()>0){
            return;
        }

        Long time = System.currentTimeMillis()/1000L;
        h5Order.setPaytime(time.intValue());
        h5Order.setCreated(time.intValue());
        h5Order.setDisposeLog("剩余curr_nums:"+mtVmChannelConfigInfoList.stream().mapToLong(MtVmChannelConfigInfo::getCurrNum).sum());

        String url= funboxProperties.getVsurl()+"/AppRequestVs.action";
        JSONObject jsonObject = new JSONObject();
        if(h5Order!=null){
            jsonObject.put("msgType","rapidVendoutV4");
            jsonObject.put("vmId",h5Order.getInnerCode());
            jsonObject.put("cn",new BigDecimal(System.currentTimeMillis()/1000L));
            JSONObject subJson = new JSONObject();
            subJson.put("orderId",orderId);
            subJson.put("mdseId",h5Order.getMdseId());
            jsonObject.put("data",subJson);
        }

        String reString = HttpClientUtil.doPost(url,jsonObject.toJSONString(), new HashMap<String, String>());

        JSONObject json = JSONObject.parseObject(reString);
        JSONObject datajson = json.getJSONObject("data");
        if("1".equals(datajson.getString("code"))){//vs调用成功则保存订单，否则不保存
            h5OrderService.save(h5Order);
        }

        redisClientTemplate.delete(orderId);

    }

    /**
     * @描述 java生成流水号
     * 14位时间戳 + 7位随机数
     */
    public String getNumberForPK(){
        String id="";
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String temp = sf.format(new Date());
        int random=(int)(Math.random()*10000);
        id=temp+random;
        return id;
    }

        /**
         * 将路径生成二维码图片
         * @author chenp
         * @param content
         * @param response
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public  void encodeQrcode(String content,HttpServletResponse response){

        if(StringUtils.isBlank(content))
                return;
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            BitMatrix bitMatrix = null;
            try {
                bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 510, 510,hints);
                bitMatrix = deleteWhite(bitMatrix);//删除白边
                BufferedImage image = toBufferedImage(bitMatrix);
                //输出二维码图片流
                try {
                    ImageIO.write(image, "png", response.getOutputStream());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (WriterException e1) {
                e1.printStackTrace();
            }
        }

    /**
     * 删除白框
     * @param matrix
     * @return
     */
    private static BitMatrix deleteWhite(BitMatrix matrix) {
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i + rec[0], j + rec[1]))
                    resMatrix.set(i, j);
            }
        }
        return resMatrix;
    }
        /**
         * 类型转换
         * @author chenp
         * @param matrix
         * @return
         */
        public static BufferedImage toBufferedImage(BitMatrix matrix) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
                }
            }
            return image;
        }
        // 特殊字符处理
        public static String UrlEncode(String src)  throws UnsupportedEncodingException {
            return URLEncoder.encode(src, "UTF-8").replace("+", "%20");
        }

    }
