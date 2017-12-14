package com.conpany.project;

import com.funbox.project.model.AppZfCache;
import com.funbox.project.service.WebChatOAuthService;
import com.funbox.project.service.impl.WebChatOAuthServiceImpl;
import com.funbox.project.utils.redis.RedisClientTemplate;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by zhao6 on 2017/11/8.
 */
public class TestWeiXinAddOrder extends Tester{
    @Resource
    WebChatOAuthService webChatOAuthService;

    @Resource
    RedisClientTemplate redisClientTemplate;
    @Test
    public void addWxAddOrder(){
        System.out.println(redisClientTemplate.get("021656182"));

        AppZfCache appZfCache = new AppZfCache();
        appZfCache.setMdseId(145);
        appZfCache.setInnerCode("0210019");
//        webChatOAuthService.wxAddOrder(appZfCache,"micromessenger");
    }
}
