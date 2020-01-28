package com.envision.spring;

import com.envision.spring.cofig.SpringConfig;
import com.envision.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AOPTestAnno {

    @Autowired
    IAccountService accountService;

    @Test
    public void test() {
        accountService.save();
    }
}
