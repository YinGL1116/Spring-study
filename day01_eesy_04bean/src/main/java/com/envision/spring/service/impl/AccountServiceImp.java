package com.envision.spring.service.impl;

import com.envision.spring.service.IAccountService;

/**
 * 账户的业务层接口实现类
 */
public class AccountServiceImp implements IAccountService {

    public AccountServiceImp() {
        System.out.println("对象已经创建");
    }


    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了……");
    }

    public void init() {
        System.out.println("对象初始化……");
    }

    public void destroy() {
        System.out.println("对象销毁……");
    }
}
