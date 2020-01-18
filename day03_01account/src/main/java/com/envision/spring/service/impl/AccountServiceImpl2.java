package com.envision.spring.service.impl;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.domain.Account;
import com.envision.spring.service.IAccountService;
import com.envision.spring.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService2")
public class AccountServiceImpl2 implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

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

    @Override
    public Account findAccountByName(String name) {
        return accountDao.findByName(name);
    }

    @Override
    public void transfer(String src, String des, float money) {
        Account srcAccount = findAccountByName(src);
        Account desAccount = findAccountByName(des);
        srcAccount.setMoney(srcAccount.getMoney() - money);
        desAccount.setMoney(desAccount.getMoney() + money);
        updateAccount(srcAccount);
        int i = 1 / 0;
        updateAccount(desAccount);
    }
}
