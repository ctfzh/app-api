package com.conpany.project;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.funbox.project.bean.Code;
import com.funbox.project.bean.Menu;
import com.funbox.project.bean.MtVmNode;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.model.*;
import com.funbox.project.service.*;
import com.funbox.project.utils.DateUtils;
import org.junit.Test;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhao6 on 2017/11/3.
 */
public class TestJson extends  Tester {
    @Resource
    private MtVmChannelConfigInfoService mtVmChannelConfigInfoService;

    @Resource
    private AppUserService appUserService;

    @Resource
    private MtVmService mtVmService;

    @Resource
    private AppUserMoneyService appUserMoneyService;

    @Resource
    private MtVmChannelConfigCariService mtVmChannelConfigCariService;

    @Resource
    private AppOrderMainService appOrderMainService;

    @Resource
    private AppOrderService appOrderService;

    @Resource
    private AppVsNotifyService appVsNotifyService;

   @Test
    public void getNumberForPK(){
        String id="";
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String temp = sf.format(new Date());
        int random=(int) (Math.random()*100000);
        id=temp+random;
       System.out.println(id);
    }

    //    @Test
    public void testJson(){
        String userId="212";
        String innerCode ="0210501";
        String menu =  "{\"menu\":[{\"menu_date\":\"2017-11-06\", \"mdse_id\":\"275\", \"nums\":\"1\"},{\"menu_date\":\"2017-11-06\", \"mdse_id\":\"20\", \"nums\":\"1\"}]}";
        String payType ="3";
        String fromToday="1";

        MtVmNode mtVmNode = mtVmService.selectByInnerCode(innerCode);

        //获取售货机可卖得商品
        List<Menu> menuList =  mtVmChannelConfigInfoService.selectMenusByInnerCode(innerCode);

        JSONObject jsonObject = JSONObject.parseObject(menu);
        JSONArray menuJsonArr = jsonObject.getJSONArray("menu");

        List<AppOrder> appOrderList = new ArrayList<>();
        BigDecimal sellingPrice = new BigDecimal(0);
        //对售货机拥有的货物进行遍历，看看库存是否够，计算总订单价格，以及组装子订单数组
        for(Menu menu1:menuList){
            for(Object obj :menuJsonArr){
                JSONObject ojbJson = null;
                if(obj!=null) {
                    ojbJson = JSONObject.parseObject(obj.toString());
                }

                //判断商品库存可足
              if(menu1.getMdseId().equals(ojbJson.getBigDecimal("mdse_id"))&&menu1.getValiDate().equals(ojbJson.getString("menu_date"))){
                    if(menu1.getSurplusSum().compareTo(ojbJson.getBigDecimal("nums"))<=0){
//                        return   ResultGenerator.genFailResult("餐品:"+menu1.getMdseName()+"数量不足");
                    }

               //汇总子订单得价格,价格先都设置成一样，不参与任何优惠
                int nums = ojbJson.getIntValue("nums");//购买了几个商品
                 sellingPrice = menu1.getOfferPrice().multiply(new BigDecimal(nums));//原价

                 //组装子订单
                AppOrder appOrder = new AppOrder();
                appOrder.setFoodDate(DateUtils.stringToDate(menu1.getValiDate()));
                appOrder.setMdseId(menu1.getMdseId());
                appOrder.setMdseName(menu1.getMdseName());
                appOrder.setNickname(menu1.getMdseNickname());
                appOrder.setMdseSubgrid(menu1.getMdseSubgrid());
                appOrder.setMdseSmallgrid(menu1.getMdseSmallgrid());
                appOrder.setMdseStaplefood(menu1.getMdseStaplefood());
                appOrder.setSellingPrice(menu1.getOfferPrice());
                appOrder.setAppPrice(menu1.getOfferPrice());//暂时没有会员价，和原价一样
                appOrder.setPayPrice(menu1.getOfferPrice());//暂时没有优惠，和原价一样
                appOrder.setDiscountName("");//php代码也为空
                appOrder.setCouponId(new BigDecimal("0"));
                appOrder.setCouponName("");
                appOrder.setNodeId(mtVmNode.getNodeId());
                appOrder.setOrderStatus(new BigDecimal("1"));
                appOrderList.add(appOrder);
              }
            }
        }

        //总订单组装
        AppOrderMain appOrderMain = new AppOrderMain();
        AppUser appUser = appUserService.findById(Integer.parseInt(userId));
        appOrderMain.setUserId(new BigDecimal(appUser.getUserId()));
        appOrderMain.setUsername(appUser.getUsername());
        appOrderMain.setNickname(appUser.getNickname());
        appOrderMain.setSellingPrice(sellingPrice);
        appOrderMain.setPayPrice(sellingPrice);
        appOrderMain.setAppPrice(sellingPrice);
        appOrderMain.setCouponId(new BigDecimal("0"));
        appOrderMain.setCouponName("");
        appOrderMain.setPayType(new BigDecimal(payType));
        appOrderMain.setInnerCode(innerCode);
        appOrderMain.setVmId(mtVmNode.getVmId());
        appOrderMain.setNodeName(mtVmNode.getNodeName());
        appOrderMain.setNodeAddress(mtVmNode.getNodeAddress());
//        appOrderMain无node_id字段 mtVmNode.getNodeId()
        appOrderMain.setOrderStatus(new BigDecimal("1"));
        appOrderMain.setCreated(new BigDecimal(System.currentTimeMillis()/1000L));//获取时间戳
        appOrderMain.setCreatedDate(new Date());
        appOrderMain.setModified(new BigDecimal(System.currentTimeMillis()/1000L));

        if (appOrderMain.getPayPrice().compareTo(new BigDecimal("0")) == -1) {
//         return   ResultGenerator.genFailResult("订单金额有误");
        }

        //如果是余额支付,检测用户的余额是否够支付这个订单的金额
        if(payType.equals("1")){
            Condition condition=new Condition(AppUserMoney.class);
            condition.createCriteria().andCondition("user_id = "+userId);
            List<AppUserMoney> appUserMoney = appUserMoneyService.findByCondition(condition);
            if(appUserMoney==null||appUserMoney.size()==0){
//                return   ResultGenerator.genFailResult("用户"+userId+"没有余额");
            }
            if(appOrderMain.getPayPrice().compareTo(new BigDecimal(appUserMoney.get(0).getMoney()))==1){
//                return   ResultGenerator.genFailResult("账户金额不够支付订单");
            }
        }

       //根据商品id以及日期查询取款码
        List<String> codes = new ArrayList<>();
        for(Object obj :menuJsonArr){
            JSONObject ojbJson = null;
            if(obj!=null) {
                ojbJson = JSONObject.parseObject(obj.toString());
            }
            codes.add(ojbJson.getString("menu_date"));
        }
        List<Code>  codeList = mtVmChannelConfigCariService.selectCodeByInnerCodeandvalidTs(innerCode,codes);
        if(codeList==null){
            ResultGenerator.genFailResult("商品剩余数量不足，请选择其他餐品");
        }

        String lockCode = "";
        for(AppOrder appOrder : appOrderList){

           //给子订单生成取货码
            for(Code code : codeList){
                // 取货码用过一次，就不能再用了
                if (lockCode.contains(code.getMvcccId().stripTrailingZeros().toPlainString())) {
                    continue;
                }
                if(DateUtils.dateToString(appOrder.getFoodDate()).equals(code.getValidDate())&&appOrder.getMdseId().equals(code.getMdseId())){
                    lockCode = lockCode+code.getMvcccId();
                    appOrder.setFoodCode(code.getCariCode());
                    appOrder.setMvcccId(code.getMvcccId());
                    appOrder.setClCode(code.getClCode());
                    break;
                }
            }
        }

        for(AppOrder appOrder : appOrderList){
            if(appOrder.getFoodCode()==null){
                ResultGenerator.genFailResult("餐品"+appOrder.getMdseName()+"剩余数量不足，请选择其他餐品");
            }
        }

        //保存主订单
//        appOrderMainService.save(appOrderMain);

        //保存子订单
        BigDecimal parentId = appOrderMain.getId();
        for(AppOrder appOrder : appOrderList){
            appOrder.setParentId(parentId);
//            appOrderService.save(appOrder);
        }

        //如果是余额支付
      if(payType.equals("1")){
            // 直接将取货码置为购买
//         int codeNum = mtVmChannelConfigCariService.updateByMvvcccIds(appOrderMain.getId().stripTrailingZeros().toPlainString(),codes);
      }


        appOrderMain.setCreated(new BigDecimal(System.currentTimeMillis()/1000L));//获取时间戳
        appOrderMain.setCreatedDate(new Date());

        //把总订单状态改成已支付
        AppOrderMain appOrderMain1 = new AppOrderMain();
        appOrderMain1.setOrderStatus(new BigDecimal("4"));
        appOrderMain1.setCreated(new BigDecimal(System.currentTimeMillis()/1000L));
        appOrderMain1.setModified(new BigDecimal(System.currentTimeMillis()/1000L));
        Condition condition = new Condition(AppOrderMain.class);
        condition.createCriteria().andCondition("id="+appOrderMain.getId()+" and order_status=1");
//        appOrderMainService.updateByConditionSelective(appOrderMain1,condition);

        //查询子订单
        AppOrder appOrder= new AppOrder();
        appOrder.setModified(new BigDecimal(System.currentTimeMillis()/1000L));
        Condition condition1 = new Condition(AppOrderMain.class);
        condition1.createCriteria().andCondition("parent_id="+appOrderMain.getId()+" and order_status=1");
        List<AppOrder> appOrders = appOrderService.findByCondition(condition1);

        //更改子订单状态，改为已支付，4
        for(AppOrder appOrder1 : appOrders){
            appOrder1.setOrderStatus(new BigDecimal("4"));
            appOrder1.setModified(new BigDecimal(System.currentTimeMillis()/1000L));
            Condition condition2 = new Condition(AppOrder.class);
            condition2.createCriteria().andCondition("id="+appOrderMain.getId()+" and order_status=1");
      //      appOrderService.updateByConditionSelective(appOrder1,condition2);
        }

        // 通知VS购买
        // 获取通知vs用的子订单
        JSONArray jsonArray = new JSONArray();
        for(AppOrder appOrder1 : appOrders){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("buyDate",appOrder1.getFoodDate());
            jsonObj.put("productId",appOrder1.getMdseId());
            jsonObj.put("clCode",appOrder1.getClCode());
            jsonObj.put("blno",appOrder1.getFoodCode());
            jsonObj.put("orderId",appOrder1.getOrderId());
            jsonArray.add(jsonObj);
        }

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("msgType","checkBuy");
        jsonObject1.put("vmId",innerCode);
        jsonObject1.put("data",jsonArray);

        AppVsNotify appVsNotify = new AppVsNotify();
        appVsNotify.setNotifyFlag("buy");
        appVsNotify.setInnerCode(innerCode);
        appVsNotify.setRequestContent(jsonObject1.toString());
        appVsNotify.setMainOrderId(0);
        appVsNotify.setCreated((int)(System.currentTimeMillis()/1000L));
//        appVsNotifyService.save(appVsNotify);

//        return ResultGenerator.genSuccessResult();
    }

//    @Test
    public void testUpdate(){
        AppUser appUser = new AppUser();
        appUser.setPasswd("123");
        Condition condition = new Condition(AppUser.class);
        condition.createCriteria().andCondition("username = '15950081243'");
        appUserService.updateByConditionSelective(appUser,condition);
    }
}
