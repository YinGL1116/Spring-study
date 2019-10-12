package com.envision.spring.factory;

import com.envision.spring.service.IAccountService;
import com.envision.spring.service.impl.AccountServiceImp;

/**
 * 创建一个工厂类 该类可能存在于jar包中 我们无法通过修改源码的方式来提供默认构造函数
 */
public class StaticFactory {

    public static IAccountService getAccountService() {
        return new AccountServiceImp();
    }
}