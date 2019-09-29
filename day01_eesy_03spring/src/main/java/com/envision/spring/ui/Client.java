package com.envision.spring.ui;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.service.IAccountService;
import com.envision.spring.service.impl.AccountServiceImp;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * 获取spring的ioc核心容器 并根据ID获取对象
     * @param args
     */
    public static void main(String[] args) {

        //1获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2根据ID获取bean对象
        IAccountService accountService = (IAccountService)ac.getBean("accountService");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);



    }
}
