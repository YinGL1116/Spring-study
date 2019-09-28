package com.envision.service.impl;

import com.envision.dao.IAccountDao;
import com.envision.dao.impl.AccountDaoImpl;
import com.envision.factory.BeanFactory;
import com.envision.service.IAccountService;

/**
 * 账户的业务层接口实现类
 */
public class AccountServiceImp implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

    private int i = 1;

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
