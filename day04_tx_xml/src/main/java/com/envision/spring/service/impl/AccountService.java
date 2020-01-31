package com.envision.spring.service.impl;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.domain.Account;
import com.envision.spring.service.IAccountService;

public class AccountService implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public void transfer(String src, String des, float money) {
        Account srcAccount = accountDao.findByName(src);
        Account desAccount = accountDao.findByName(des);
        srcAccount.setMoney(srcAccount.getMoney() - money);
        desAccount.setMoney(desAccount.getMoney() + money);
        accountDao.update(srcAccount);
        int i = 1 / 0;
        accountDao.update(desAccount);
    }
}
