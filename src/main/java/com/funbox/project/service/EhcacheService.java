package com.funbox.project.service;

import com.alibaba.fastjson.JSONObject;
import com.funbox.project.core.ProjectConstant;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by zhao6 on 2017/12/14.
 */
@Service
public class EhcacheService {
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String SENDMSG_CACHE_NAME = "sendmsg";

    @CachePut(value = SENDMSG_CACHE_NAME,key ="'funbox_api_'+#phone")
    public JSONObject setCacheUserCode(String phone, JSONObject jsonObject){
           return jsonObject;
    }

    @Cacheable(value = SENDMSG_CACHE_NAME,key ="'funbox_api_'+#phone")
    public JSONObject getCacheUserCode(String phone){
        return null;
    }



}
