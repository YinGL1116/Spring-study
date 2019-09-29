package com.envision.spring.service.impl;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.dao.impl.AccountDaoImpl;
import com.envision.spring.service.IAccountService;

/**
 * 账户的业务层接口实现类
 */
public class AccountServiceImp implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
