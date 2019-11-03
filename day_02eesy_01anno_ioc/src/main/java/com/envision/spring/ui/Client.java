package com.envision.spring.ui;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.dao.impl.AccountDaoImpl;
import com.envision.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {


        //1获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //读取磁盘任意位置的配置文件实例
        //ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\……");
        //2根据ID获取bean对象
        IAccountService accountService = (IAccountService)ac.getBean("accountService");


        System.out.println(accountService);

        IAccountDao accountDao = ac.getBean("accountDao", AccountDaoImpl.class);
        System.out.println(accountDao);

        //accountService.saveAccount();

    }
}
