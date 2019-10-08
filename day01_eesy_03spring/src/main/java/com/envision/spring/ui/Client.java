package com.envision.spring.ui;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.service.IAccountService;
import com.envision.spring.service.impl.AccountServiceImp;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    /**
     * 获取spring的ioc核心容器 并根据ID获取对象
     *
     * ApplicationContext 的三个常用实现类
     *  ClassPathXmlApplicationContext 可以加载类路径下的配置文件  要求配置文件必须在类路径下（常用）
     *  FileSystemXmlApplicationContext 可以加载磁盘上的配置文件 必须有权限
     *
     * 核心容器的两个接口引发的问题
     * ApplicationContext:  单例对象使用
     *      在构建核心容器时创建对象采取的策略是采用  立即加载  的方式 只要一读取完配置文件马上就创建配置文件中的对象
     * BeanFactory  多例对象使用
     *      在构建核心容器时创建对象采取的策略是  延迟加载  的方式 什么时候根据id获取对象了 什么时候才真正创建对象
     * @param args
     */
    public static void main(String[] args) {

        /*
        //1获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //读取磁盘任意位置的配置文件实例
        //ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\……");
        //2根据ID获取bean对象
        IAccountService accountService = (IAccountService)ac.getBean("accountService");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);

         */
        //-----------BeanFactory--------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService)factory.getBean("accountService");
        System.out.println(as);

    }
}
