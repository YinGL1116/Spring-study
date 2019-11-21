package com.envision.spring.service.impl;

import java.util.List;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.domain.Account;
import com.envision.spring.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.delete(accountId);
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAll();
    }
}
