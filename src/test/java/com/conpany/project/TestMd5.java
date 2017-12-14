package com.conpany.project;

import com.alibaba.fastjson.JSONObject;
import com.funbox.project.utils.EncryptUtil;

/**
 * Created by zhao6 on 2017/11/14.
 */
public class TestMd5 {
    public static void main(String[] args) {
        String param="123456";
        String code2 = EncryptUtil.encryptWithMD5(param);
        System.out.println(EncryptUtil.encryptWithMD5(code2));

//        f59bd65f7edafb087a81d4dca06c4910
//        String jsonString = " {\"sn\":1511943044,\"data\":{\"message\":\"未连接的售货机，或连接已经断开。inner_code=0512004\",\"code\":-1},\"msgType\":\"rapidVendoutV4Response\"}";
//
//        JSONObject json = JSONObject.parseObject(jsonString);
//        JSONObject datajson = json.getJSONObject("data");
//        System.out.println(datajson.get("code"));

    }
}
