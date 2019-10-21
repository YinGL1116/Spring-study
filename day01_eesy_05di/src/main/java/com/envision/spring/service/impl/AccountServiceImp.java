package com.envision.spring.service.impl;

import com.envision.spring.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层接口实现类
 */
public class AccountServiceImp implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImp(String name, Integer age, Date birthday) {
        System.out.println("对象已经创建");
        this.age = age;
        this.birthday = birthday;
        this.name = name;
    }


    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了……" + name + age + birthday);
    }
}
