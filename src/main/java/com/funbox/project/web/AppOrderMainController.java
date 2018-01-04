package com.funbox.project.web;

import com.alibaba.fastjson.JSONObject;
import com.funbox.project.bean.Menu;
import com.funbox.project.bean.MtVmNode;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.model.AppOrder;
import com.funbox.project.model.AppOrderMain;
import com.funbox.project.service.AppOrderMainService;
import com.funbox.project.service.AppOrderService;
import com.funbox.project.service.MtVmChannelConfigInfoService;
import com.funbox.project.service.MtVmService;
import com.funbox.project.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
* Created by CodeGenerator on 2017/10/31.
*/
@RestController
@RequestMapping("/v4/app/order/main")
public class AppOrderMainController {
    @Resource
    private AppOrderMainService appOrderMainService;

    @Resource
    private AppOrderService appOrderService;

    @Resource
    private MtVmService mtVmService;

    @Resource
    private MtVmChannelConfigInfoService mtVmChannelConfigInfoService;


    /**
     * 根据用户id、售货机innerCode、订单状态orderStatus查询订单
     * @param page
     * @param size
     * @param userId
     * @param innerCode
     * @param orderStatus
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping("/list")
    public Result listByUserid(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
                               @RequestParam("userId") String userId,@RequestParam("innerCode") String innerCode,@RequestParam("orderStatus") String orderStatus) throws InvocationTargetException, IllegalAccessException {
        if(StringUtils.isBlank(userId)){
            return  ResultGenerator.genFailResult("用户id为空");
        }

        if(StringUtils.isBlank(innerCode)){
            return  ResultGenerator.genFailResult("售货机编码为空");
        }


        Condition condition1=new Condition(AppOrderMain.class);
        condition1.createCriteria().andCondition("user_id ="+userId+" and inner_code ="+innerCode);
        if((!"0".equals(orderStatus)||!"4".equals(orderStatus))&&StringUtils.isNotBlank(orderStatus)) {
                condition1.and().andCondition("order_status=" + orderStatus);
        }

        condition1.orderBy("id").desc();
        PageHelper.startPage(page, size);
        List<AppOrderMain> list = appOrderMainService.findByCondition(condition1);

        if(list==null||list.size()==0){
         return  ResultGenerator.genFailResult("未查到状态为："+orderStatus+" 的数据");
        }

        StringBuilder sb = new StringBuilder();
        for(AppOrderMain appOrderMain : list){
            sb.append(appOrderMain.getId()).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());

        Condition condition2=new Condition(AppOrder.class);
        condition2.createCriteria().andCondition("parent_id in ("+sb.toString()+")");
        if(!"0".equals(orderStatus)&&StringUtils.isNotBlank(orderStatus)) {
            condition1.and().andCondition("order_status=" + orderStatus);
        }
        if("4".equals(orderStatus)&&StringUtils.isNotBlank(orderStatus)) {
            condition1.and().andCondition("order_status!=7");
        }
        condition2.orderBy("foodDate").desc();
        List<AppOrder> appOrderList = appOrderService.findByCondition(condition2);

        //根据一级主订单遍历下面的子订单
        for(AppOrderMain appOrderMain :list){
               List<AppOrder> newAppOrderList = appOrderList.stream().filter(s->s.getParentId().equals(appOrderMain.getId())).collect(Collectors.toList());

               Map<Date, List<AppOrder>> groupBy = newAppOrderList.stream().collect(Collectors.groupingBy(AppOrder::getFoodDate));
               List<List<AppOrder>> appOrderLists = new ArrayList<>();
                for (Date key : groupBy.keySet()) {
                appOrderLists.add(groupBy.get(key));
                }

               appOrderMain.setOrderList(appOrderLists);
                if(appOrderLists==null||appOrderLists.size()==0){
                    list.remove(appOrderMain);
                }
        }

        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据用户id、售货机innerCode、订单状态orderStatus查询订单
     * @param page
     * @param size
     * @param userId
     * @param innerCode
     * @param orderStatus
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping("/sublist")
    public Result listAppOrderByUserid(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,
                                       @RequestParam("userId") String userId,@RequestParam("innerCode") String innerCode,@RequestParam("orderStatus") String orderStatus) throws InvocationTargetException, IllegalAccessException {
        if(StringUtils.isBlank(userId)){
            return  ResultGenerator.genFailResult("用户id为空");
        }

        if(StringUtils.isBlank(innerCode)){
            return  ResultGenerator.genFailResult("售货机编码为空");
        }

        Condition condition=new Condition(AppOrder.class);
        condition.createCriteria().andCondition("user_id ="+userId+" and inner_code ="+innerCode+" and food_date ='"+ DateUtils.dateToString(new Date())+"'");
        if(!"0".equals(orderStatus)&&StringUtils.isNotBlank(orderStatus)){
            condition.and().andCondition( "order_status="+orderStatus);
        }
        condition.orderBy("foodDate").desc();

        PageHelper.startPage(page, size);
        List<AppOrder> appOrderList = appOrderService.findByCondition(condition);

        Map<Date, List<AppOrder>> groupBy = appOrderList.stream().collect(Collectors.groupingBy(AppOrder::getFoodDate));

        List<List<AppOrder>> appOrders = new ArrayList<>();
        for (Date key : groupBy.keySet()) {
            appOrders.add(groupBy.get(key));
        }

        PageInfo pageInfo = new PageInfo(appOrders);

        return ResultGenerator.genSuccessResult(pageInfo);

    }


    /**
     * 根据用户id、订单状态orderStatus查询订单
     * @param page
     * @param size
     * @param userId
     * @param orderStatus
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping("/list/userid")
    public Result listByUid(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,
                               @RequestParam("userId") String userId,@RequestParam("orderStatus") String orderStatus) throws InvocationTargetException, IllegalAccessException {
        if(StringUtils.isBlank(userId)){
            return  ResultGenerator.genFailResult("用户id为空");
        }

        Condition condition1=new Condition(AppOrderMain.class);
        condition1.createCriteria().andCondition("user_id ="+userId);
        if(!"0".equals(orderStatus)&&StringUtils.isNotBlank(orderStatus)) {
            condition1.and().andCondition("order_status=" + orderStatus);
        }
        if("4".equals(orderStatus)&&StringUtils.isNotBlank(orderStatus)) {
            condition1.and().andCondition("order_status!=7");
        }

        condition1.orderBy("id").desc();
        PageHelper.startPage(page, size);
        List<AppOrderMain> list = appOrderMainService.findByCondition(condition1);

        if(list==null||list.size()==0){
            return  ResultGenerator.genFailResult("未查到状态为："+orderStatus+" 的数据");
        }

        StringBuilder sb = new StringBuilder();
        for(AppOrderMain appOrderMain : list){
            sb.append(appOrderMain.getId()).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());

        Condition condition2=new Condition(AppOrder.class);
        condition2.createCriteria().andCondition("parent_id in ("+sb.toString()+")");
        if("4".equals(orderStatus)&&StringUtils.isNotBlank(orderStatus)){
            condition2.and().andCondition( "food_date ='"+ DateUtils.dateToString(new Date())+"'" + "and isRefund='no' ");
        }
        condition2.orderBy("foodDate").desc();
        List<AppOrder> appOrderList = appOrderService.findByCondition(condition2);

        //根据一级主订单遍历下面的子订单
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object object = iter.next();
            AppOrderMain appOrderMain =  (AppOrderMain)object;
            List<AppOrder> newAppOrderList = appOrderList.stream().filter(s->s.getParentId().equals(appOrderMain.getId())).collect(Collectors.toList());

            Map<Date, List<AppOrder>> groupBy = newAppOrderList.stream().collect(Collectors.groupingBy(AppOrder::getFoodDate));
            List<List<AppOrder>> appOrderLists = new ArrayList<>();
            for (Date key : groupBy.keySet()) {
                appOrderLists.add(groupBy.get(key));
            }


            appOrderMain.setOrderList(appOrderLists);
            if(appOrderLists==null||appOrderLists.size()==0){
                iter.remove();
            }

            if(list==null) break;
        }

        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 根据订单号查询可退订的订单订单
     * @param orderNo
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping("{orderNo}/list")
    public Result listByOrderNo(@PathVariable("orderNo") String orderNo) throws InvocationTargetException, IllegalAccessException {
        if(StringUtils.isBlank(orderNo)){
            return  ResultGenerator.genFailResult("orderNo为空");
        }

        Condition condition1=new Condition(AppOrderMain.class);
        condition1.createCriteria().andCondition("id ="+orderNo);
        List<AppOrderMain> list = appOrderMainService.findByCondition(condition1);

        if(list==null||list.size()==0){
            return  ResultGenerator.genFailResult("未查到orderNo为："+orderNo+" 的数据");
        }

        StringBuilder sb = new StringBuilder();
        for(AppOrderMain appOrderMain : list){
            sb.append(appOrderMain.getId()).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());

        Condition condition2=new Condition(AppOrder.class);
        condition2.createCriteria().andCondition("parent_id in ("+sb.toString()+")");
        condition2.and().andCondition( "food_date >='"+ DateUtils.dateToString(new Date())+"'" + "and isRefund='no' ");
        condition2.orderBy("foodDate").desc();
        List<AppOrder> appOrderList = appOrderService.findByCondition(condition2);

        //根据一级主订单遍历下面的子订单
        for(Iterator iter = list.iterator(); iter.hasNext();){
            Object object = iter.next();
            AppOrderMain appOrderMain =  (AppOrderMain)object;
            List<AppOrder> newAppOrderList = appOrderList.stream().filter(s->s.getParentId().equals(appOrderMain.getId())).collect(Collectors.toList());

            Map<Date, List<AppOrder>> groupBy = newAppOrderList.stream().collect(Collectors.groupingBy(AppOrder::getFoodDate));
            List<List<AppOrder>> appOrderLists = new ArrayList<>();
            for (Date key : groupBy.keySet()) {
                appOrderLists.add(groupBy.get(key));
            }


            appOrderMain.setOrderList(appOrderLists);
            if(appOrderLists==null||appOrderLists.size()==0){
                iter.remove();
            }

            if(list==null) break;
        }

        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 根据用户id、订单状态orderStatus查询订单
     * @param page
     * @param size
     * @param userId
     * @param orderStatus
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PostMapping("/sublist/userid")
    public Result listSubOrderByUserid(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,
                                       @RequestParam("userId") String userId,@RequestParam("orderStatus") String orderStatus) throws InvocationTargetException, IllegalAccessException {
        if(StringUtils.isBlank(userId)){
            return  ResultGenerator.genFailResult("用户id为空");
        }

        Condition condition=new Condition(AppOrder.class);
        condition.createCriteria().andCondition("user_id ="+userId+" and food_date ='"+ DateUtils.dateToString(new Date())+"'");
        if(!"0".equals(orderStatus)&&StringUtils.isNotBlank(orderStatus)){
            condition.and().andCondition( "order_status="+orderStatus);
        }
        condition.orderBy("foodDate").desc();

        PageHelper.startPage(page, size);
        List<AppOrder> appOrderList = appOrderService.findByCondition(condition);

        Map<Date, List<AppOrder>> groupBy = appOrderList.stream().collect(Collectors.groupingBy(AppOrder::getFoodDate));

        List<List<AppOrder>> appOrders = new ArrayList<>();
        for (Date key : groupBy.keySet()) {
            appOrders.add(groupBy.get(key));
        }

        PageInfo pageInfo = new PageInfo(appOrders);

        return ResultGenerator.genSuccessResult(pageInfo);

    }


        @PostMapping("/add/order")
    public Result addOrder(@RequestParam String userId,@RequestParam String innerCode,@RequestParam String menu,
                           @RequestParam String payType,@RequestParam String fromToday) {
            if(StringUtils.isBlank(userId)){
                ResultGenerator.genFailResult("用户ID不能为空");
            }
            if(StringUtils.isBlank(innerCode)){
                ResultGenerator.genFailResult("售货机编号不能为空");
            }
            MtVmNode mtVmNode = mtVmService.selectByInnerCode(innerCode);
            if(mtVmNode==null){
                ResultGenerator.genFailResult("售货机不存在");
            }
            String payTypes = "1,2,3,4,5";
            if(!payTypes.contains(payType)){
                ResultGenerator.genFailResult("支付方式不支持");
            }
            if(isJson(menu)){
                ResultGenerator.genFailResult("购买餐品数据格式有误");
            }

           JSONObject menuIsonObject = JSONObject.parseObject(menu);
            //获取售货机可卖得商品
            List<Menu> menuList =  mtVmChannelConfigInfoService.selectMenusByInnerCode(innerCode);
            for(Menu menu1 : menuList){
//                if(menuIsonObject.)
            }


        return ResultGenerator.genSuccessResult("");
    }

    /**
     * 判断是否是json
     * @param json
     * @return
     */
    private static boolean isJson(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonParseException e) {
            return false;
        }
    }
}
