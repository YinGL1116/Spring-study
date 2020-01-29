package com.envision.spring.factory;

import com.envision.spring.service.IAccountService;
import com.envision.spring.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class BeanFactory {

    @Autowired
    TransactionManager manager;

    @Autowired
    @Qualifier("accountService2")
    IAccountService accountService;

    //accountService.getClass().getClassLoader() == IAccountService.class.getClassLoader()
    public IAccountService getAccountService() {
        return (IAccountService)Proxy.newProxyInstance(IAccountService.class.getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            //1. 开启事务
                            manager.begin();
                            //2. 执行操作
                            Object result = method.invoke(accountService, args);
                            //3. 提交事务
                            manager.commit();
                            //4. 返回结果
                            return result;
                        } catch (Exception e) {
                            //5. 回滚事务
                            manager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6. 释放连接
                            manager.release();
                        }

                    }
                });
    }

}
