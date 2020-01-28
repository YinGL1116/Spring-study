package com.envision.spring;

import com.envision.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.net.ApplicationProxy;

public class AOPTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //这里 直接获取了这个bean 它是增强后的bean 也就是说是增加了通知方法的bean 不只是原来简单的bean
        IAccountService accountService = (IAccountService)applicationContext.getBean("accountService");

        accountService.save();
        accountService.update(1);
        accountService.delete();
    }
}
