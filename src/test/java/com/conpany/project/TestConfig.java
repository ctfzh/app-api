package com.conpany.project;

import com.funbox.project.configurer.FunboxProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhao6 on 2017/11/10.
 */
public class TestConfig extends Tester{
    @Autowired
    FunboxProperties funboxProperties;

    @Test
    public void test(){
        System.out.println(funboxProperties.appid);
    }
}
