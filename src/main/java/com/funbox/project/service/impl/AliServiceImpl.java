package com.funbox.project.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.funbox.project.configurer.FunboxProperties;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.exception.PayException;
import com.funbox.project.exception.build.BaseExceptionBuild;
import com.funbox.project.model.AppZfCache;
import com.funbox.project.model.H5Order;
import com.funbox.project.model.MtVmChannelConfigInfo;
import com.funbox.project.service.AliPayService;
import com.funbox.project.service.H5OrderService;
import com.funbox.project.service.MtVmChannelConfigInfoService;
import com.funbox.project.utils.AlipayConfig;
import com.funbox.project.utils.redis.RedisClientTemplate;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhao6 on 2017/11/10.
 */
@Service
public class AliServiceImpl implements AliPayService {

    @Resource
    private MtVmChannelConfigInfoService mtVmChannelConfigInfoService;

    @Resource
    private H5OrderService h5OrderService;

    @Autowired
    FunboxProperties funboxProperties;

    @Autowired
    RedisClientTemplate redisClientTemplate;

    @Value("${spring.funbox.zfb_notify_url}")
    private String notifyurl;

    private static Logger lg=Logger.getLogger(AliServiceImpl.class);
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;

/**
 * 获取支付宝支付的二维码地址
 * @return
 * @author chenp
 * @throws Exception
 */
@Override
@Transactional
public  Result getCodeUrl(AppZfCache zfCache){
            //根据售货机id和商品id查询有多少商品
            Condition condition = new Condition(MtVmChannelConfigInfo.class);
            condition.createCriteria().andCondition("inner_code = "+zfCache.getInnerCode()+" and mdse_id = "+zfCache.getMdseId());
            List<MtVmChannelConfigInfo> mtVmChannelConfigInfoList = mtVmChannelConfigInfoService.findByCondition(condition);

            if(mtVmChannelConfigInfoList.size()<=0){
                throw new PayException(BaseExceptionBuild.buildData(BaseExceptionBuild.PRODUCTS_SOLD_OUT_ERROR));
            }
            if(mtVmChannelConfigInfoList.get(0).getAppZfbPrice().compareTo(new BigDecimal("0"))<=0){
                throw new PayException(BaseExceptionBuild.buildData(BaseExceptionBuild.PRODUCTS_SOLD_OUT_ERROR));
            }

            String randomNum = getNumberForPK();

            //实例化客户端
            AlipayClient alipayClient = AlipayConfig.getAlipayClient(); // 获得初始化的AlipayClient
            AlipayTradePrecreateRequest alipayRequest = new AlipayTradePrecreateRequest();// 创建API对应的request
            alipayRequest.setReturnUrl(notifyurl);// 回跳地址
            alipayRequest.setNotifyUrl(notifyurl);// 通知地址
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("out_trade_no", randomNum);// 订单号
            map.put("total_amount",  mtVmChannelConfigInfoList.get(0).getAppZfbPrice().divide(new BigDecimal("100")));// 交易金额,单位:元
//            map.put("total_amount",  "0.01");
            map.put("subject", mtVmChannelConfigInfoList.get(0).getMdseName());// 订单标题
            map.put("timeout_express","90m");
            map.put("body",zfCache.getInnerCode()+zfCache.getMdseId());

            alipayRequest.setBizContent(JSON.toJSONString(map));
            AlipayTradePrecreateResponse response = null;
            try {
                response = alipayClient.execute(alipayRequest);
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            System.out.print(response.getBody());



            if("10000".equals(response.getCode())){
               //保存H5订单
                H5Order h5Order = new H5Order();
                h5Order.setOrderId(randomNum);
                h5Order.setOrderStatus(4);
                h5Order.setPayType(2);
                h5Order.setInnerCode(zfCache.getInnerCode());
                h5Order.setMdseId(zfCache.getMdseId());
                h5Order.setMdseName(mtVmChannelConfigInfoList.get(0).getMdseName());
                h5Order.setPrice(mtVmChannelConfigInfoList.get(0).getAppZfbPrice().intValue());
                BigDecimal time = new BigDecimal(System.currentTimeMillis()/1000L);
                h5Order.setCreated(time.intValue());
                redisClientTemplate.set(randomNum,h5Order);
            }

            return ResultGenerator.genSuccessResult(response.getQrCode());
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
