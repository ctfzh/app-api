package com.funbox.project.web;

import com.alibaba.fastjson.JSONObject;
import com.funbox.project.core.Result;
import com.funbox.project.core.ResultGenerator;
import com.funbox.project.model.AppUser;
import com.funbox.project.model.AppUserPhone;
import com.funbox.project.service.AppUserPhoneService;
import com.funbox.project.service.AppUserService;
import com.funbox.project.service.impl.EhcacheService;
import com.funbox.project.utils.HttpClientUtil;
import com.funbox.project.utils.MD5Util;
import com.funbox.project.utils.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Created by CodeGenerator on 2017/10/27.
*/
@RestController
@RequestMapping("/v4/app/user")
public class AppUserController {
    @Resource
    private AppUserService appUserService;

    @Resource
    private AppUserPhoneService appUserPhoneService;

    @Autowired
    private EhcacheService ehcacheService;

    private static final String iosPhoneTest ="18101038433";

    @PostMapping("/code")
    @Transactional
    public Result getCode(@RequestParam() String phone) {
        if (StringUtils.isBlank(phone)) {
            return ResultGenerator.genFailResult("手机号不能为空");
        }

        Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
        Matcher m = p.matcher(phone);
        if (false == m.matches()) {
            return ResultGenerator.genFailResult("手机号格式不正确");
        }

        //预防短信轰炸
        if(ehcacheService.getCacheUserCode(phone)!=null) {
            Long sendTime = ehcacheService.getCacheUserCode(phone).getLong("sendTime");
            Long s = (System.currentTimeMillis() - sendTime) / (1000 * 60);
            if (1 > s) {
                return ResultGenerator.genFailResult("请1分钟后重新获取");
            }
        }

        String phoneCode;//如果时苹果验证的手机号，自动分配一个6666的验证码，否则走短信网关获取
        if(!iosPhoneTest.equals(phone)){
            //取四位数字验证码
               phoneCode = new RandomUtil().getRandomString(4, "i");

            //短信发送验证码
            String url= "http://si.800617.com:4400/SendSms.aspx?un=bjsq-1&pwd=eaf9ba&mobile="+phone+"&msg=验证码："+phoneCode+"，您正在登陆三全鲜食账号。如非本人操作，请忽略该短信。";
            String reString = HttpClientUtil.doGet(url, new HashMap<String, String>());

            if(!reString.equals("result=1&")){
                ResultGenerator.genFailResult("验证码发送失败");
            }

        }else{
            phoneCode="6666";
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phoneCode",phoneCode);
        jsonObject.put("sendTime",System.currentTimeMillis());
        ehcacheService.setCacheUserCode(phone,jsonObject);

        return ResultGenerator.genSuccessResult("验证码发送成功");
    }


    @PostMapping("/login")
    @Transactional
    public Result login(@RequestParam() String phone, @RequestParam() String code) {
        if (StringUtils.isBlank(phone)) {
            return ResultGenerator.genFailResult("手机号不能为空");
        }

        if (StringUtils.isBlank(code)) {
            return ResultGenerator.genFailResult("短信验证码不能为空");
        }

        Pattern p = Pattern.compile("^1[3|4|5|7|8|9|6][0-9]{9}$");
        Matcher m = p.matcher(phone);
        if (false == m.matches()) {
            return ResultGenerator.genFailResult("手机号格式不正确");
        }

        AppUser user =  appUserService.findBy("username",phone);
        AppUser user1 = new AppUser();
        if (null == user) {
            Integer userId = appUserService.getUserId();
            AppUser appUser = new AppUser();
            appUser.setUserId(userId);
            appUser.setUsername(phone);
            appUser.setFlag(1);//手机注册为1
            appUser.setPasswd(MD5Util.MD5Encode(phone,"utf-8"));
            appUser.setCreated(Integer.parseInt(System.currentTimeMillis() / 1000L + ""));
            appUserService.save(appUser);

            user1 = appUserService.findBy("username",phone);

            AppUserPhone appUserPhone = new AppUserPhone();
            appUserPhone.setId(appUserPhoneService.getAppUserPhoneId());
            appUserPhone.setPhone(phone);
            appUserPhone.setCreated(Integer.parseInt(System.currentTimeMillis() / 1000L + ""));
            appUserPhone.setUserId(userId);
            appUserPhoneService.save(appUserPhone);
        }

        if(ehcacheService.getCacheUserCode(phone)==null){
            return  ResultGenerator.genFailResult("短信验证码超时，请从新获取验证码");
        }

        String sessionPhoneCode = ehcacheService.getCacheUserCode(phone).getString("phoneCode");
        if(!sessionPhoneCode.equals(code)){
            return  ResultGenerator.genFailResult("短信验证码错误，登陆失败");
        }

        if(user!=null){
            return ResultGenerator.genSuccessResult(user);
        }else{
            return ResultGenerator.genSuccessResult(user1);
        }
    }

    @PostMapping("/register")
    @Transactional
    public  Result register(@RequestParam String phone,int userId){
        try {
            AppUser user =  appUserService.findBy("username",phone);
            if (null == user) {
                AppUser appUser = new AppUser();
                appUser.setUserId(userId);
                appUser.setUsername(phone);
                appUser.setPasswd(MD5Util.MD5Encode(phone,"utf-8"));
                appUser.setFlag(1);//手机注册为1
                appUser.setCreated(Integer.parseInt(System.currentTimeMillis() / 1000L + ""));
                appUserService.save(appUser);

                AppUserPhone appUserPhone = new AppUserPhone();
                appUserPhone.setId(appUserPhoneService.getAppUserPhoneId());
                appUserPhone.setPhone(phone);
                appUserPhone.setCreated(Integer.parseInt(System.currentTimeMillis() / 1000L + ""));
                appUserPhone.setUserId(appUser.getUserId());
                appUserPhoneService.save(appUserPhone);
            }else{
             return  ResultGenerator.genFailResult("已经注册");
            }
        }catch (Exception e){
          return ResultGenerator.genFailResult(e.getMessage());
        }

        return ResultGenerator.genSuccessResult();

    }

}
