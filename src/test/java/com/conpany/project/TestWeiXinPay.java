package com.conpany.project;

import com.funbox.project.utils.PayUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestWeiXinPay extends Tester {

    @Test
    public void test(){
        Map<String, String> packageParams = new HashMap<String, String>();
        String nonce_str = getRandomStringByLength(32);
        packageParams.put("mch_id", "1489007712");
        packageParams.put("nonce_str", nonce_str);


        String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
        String mysign = PayUtil.sign(prestr,"1zNRmt9YNM1cub9adwZDqESYGNf3oE8Q", "utf-8").toUpperCase();

        //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
        String xml = "<xml>"
                + "<mch_id>" + "1489007712" + "</mch_id>"
                + "<nonce_str>" + nonce_str + "</nonce_str>"
                + "<sign>" + mysign + "</sign>"
                + "</xml>";

        System.out.println("调试模式_统一下单接口 请求XML数据：" + xml);

        //调用统一下单接口，并接受返回的结果
        String result = PayUtil.httpRequest("https://apitest.mch.weixin.qq.com/sandboxnew/pay/getsignkey", "POST", xml);

        System.out.println(result);
    }


    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
