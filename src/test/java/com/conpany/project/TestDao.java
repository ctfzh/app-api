package com.conpany.project;

import com.alibaba.fastjson.JSONObject;
import com.funbox.project.core.ProjectConstant;
import com.funbox.project.dao.mysql.AppCommonProblemMapper;
import com.funbox.project.dao.mysql.AppOrderMapper;
import com.funbox.project.dao.oracle.AppUserMapper;
import com.funbox.project.dao.oracle.AppUserPhoneMapper;
import com.funbox.project.dao.oracle.*;
import com.funbox.project.service.*;
import com.funbox.project.utils.EncryptUtil;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by zhao6 on 2017/10/27.
 */
public class TestDao extends Tester {

    @Resource
    AppUserService appUserService;

    @Resource
    AppUserPhoneMapper appUserPhoneMapper;

    @Resource
    AppCommonProblemMapper appCommonProblemMapper;

    @Resource
    MtMdseAppurlMapper mtMdseAppurlMapper;

    @Resource
    private AppOracleUserMapper appOracleUserMapper;

    @Resource
    private AppUserMapper appUserMapper;

    @Resource
    AppOrderMapper appOrderMapper;

    @Resource
    AppOrderService appOrderService;

    @Resource
    AppOrderMainService appOrderMainService;

    @Resource
    MtVmService mtVmService;

    @Resource
    MtVmChannelConfigInfoService mtVmChannelConfigInfoService;

//    @org.junit.Test
    public void oracle(){
//        AppOracleUser appUser = appUserService.findByPhone1("15950081243");
//        System.out.println(appUser);
//        appCommonProblemMapper.selectAll();
//        appUserPhoneMapper.selectAll();
//        mtMdseAppurlMapper.selectAll();
//        appOracleUserMapper.findByPhone("1111");
//        appUserMapper.findByPhone("111111");
//        appOrderMapper.selectAll();

//        Condition condition=new Condition(AppOrder.class);
//        condition.createCriteria().andCondition("user_id =1");
//        List<AppOrder> list = appOrderService.findByCondition(condition);

//        Map map = new HashMap();
//        map.put("ids","11,,11,11");
//        List<AppOrder> appOrderList = appOrderService.findByIds( "1,2,3,4");
//        appOrderService.findBy("userId",new BigDecimal("118"));
//
//
//        appOrderMapper.selectByIds("1,1,10");

//        Example example = new Example(AppOrder.class);
//        example.createCriteria().andCondition("user_id =153 ");
//        appOrderMapper.selectByExample(example);
//
//        appUserMapper.selectByPrimaryKey(1);
//
//        appUserService.findBy("username","15950081243");

//
//        String userId="112";
//        String innerCode="121221";
//        String orderStatus = "1";
//        Condition condition1=new Condition(AppOrder.class);
//        condition1.createCriteria().andCondition("user_id ="+userId+" and inner_code ="+innerCode+"and order_status="+orderStatus );
//        List<AppOrderMain> list1 = appOrderMainService.findByCondition(condition1);

//        System.out.println(mtVmService.selectByInnerCode("0210501"));

        mtVmChannelConfigInfoService.selectMenusByInnerCode("0210501");

    }

//    @org.junit.TestDao
    public void TestRedis(){
//        Long sendTime = JSONObject.parseObject(redisClientTemplate.get(ProjectConstant.FUNBOX_APi + "15950081243").toString()).getLong("sendTime");
//        System.out.println("sendTime------>>>>>>>>>>>>"+sendTime);
//
//        System.out.println(redisClientTemplate.get(ProjectConstant.FUNBOX_APi + "15950081243"));
//        Long s = (System.currentTimeMillis() - sendTime) / (1000 * 60);
//        if (5 < s) {
//            System.out.println("------------------------验证码发送次数过多*******************");
//        }

    }

  @Test
    public void test(){

//        System.out.println( System.currentTimeMillis()/1000L);

        String param="3cbdd2ede5bcfdf90c95d0ad6aa8d9d1clientioslocation的x116.471001y39.9156993cbdd2ede5bcfdf90c95d0ad6aa8d9d1";
        String code2 = EncryptUtil.encryptWithMD5(param);
        System.out.println(code2);
//        09CE2E4CE0BA56458B9696262823A0C5
//        x:116.471001
//        y:39.915699

//        client:ios
//        v:1.0
//        timestamp:1509329016
//        u:430
//        inner_code:0210050
//        menu_date:2017-10-30
//        from_today:0
    }
}
