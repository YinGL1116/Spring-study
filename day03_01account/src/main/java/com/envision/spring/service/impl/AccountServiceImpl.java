package com.envision.spring.service.impl;

import java.util.List;

import com.envision.spring.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.domain.Account;
import com.envision.spring.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private TransactionManager manager;

    @Override
    public void saveAccount(Account account) {
        try {
            //1. 开启事务
            manager.begin();
            //2. 执行操作
            accountDao.save(account);
            //3. 提交事务
            manager.commit();
            //4. 返回结果

        } catch (Exception e) {
            //5. 回滚事务
            manager.rollback();
        } finally {
            //6. 释放连接
            manager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {

        try {
            //1. 开启事务
            manager.begin();
            //2. 执行操作
            accountDao.update(account);
            //3. 提交事务
            manager.commit();
            //4. 返回结果

        } catch (Exception e) {
            //5. 回滚事务
            manager.rollback();
        } finally {
            //6. 释放连接
            manager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            //1. 开启事务
            manager.begin();
            //2. 执行操作
            accountDao.delete(accountId);
            //3. 提交事务
            manager.commit();
            //4. 返回结果

        } catch (Exception e) {
            //5. 回滚事务
            manager.rollback();
        } finally {
            //6. 释放连接
            manager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //1. 开启事务
            manager.begin();
            //2. 执行操作
            Account account = accountDao.findById(accountId);
            //3. 提交事务
            manager.commit();
            //4. 返回结果
            return account;
        } catch (Exception e) {
            //5. 回滚事务
            manager.rollback();
            throw new RuntimeException();
        } finally {
            //6. 释放连接
            manager.release();
        }
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1. 开启事务
            manager.begin();
            //2. 执行操作
            List<Account> accounts = accountDao.findAll();
            //3. 提交事务
            manager.commit();
            //4. 返回结果
            return accounts;
        } catch (Exception e) {
            //5. 回滚事务
            manager.rollback();
            throw new RuntimeException();
        } finally {
            //6. 释放连接
            manager.release();
        }

    }

    @Override
    public Account findAccountByName(String name) {
        try {
            //1. 开启事务
            manager.begin();
            //2. 执行操作
            Account account = accountDao.findByName(name);
            //3. 提交事务
            manager.commit();
            //4. 返回结果
            return account;
        } catch (Exception e) {
            //5. 回滚事务
            manager.rollback();
            throw new RuntimeException();
        } finally {
            //6. 释放连接
            manager.release();
        }
    }

    @Override
    public void transfer(String src, String des, float money) {
        try {
            //1. 开启事务
            manager.begin();
            //2. 执行操作
            Account srcAccount = findAccountByName(src);
            Account desAccount = findAccountByName(des);
            srcAccount.setMoney(srcAccount.getMoney() - money);
            desAccount.setMoney(desAccount.getMoney() + money);
            updateAccount(srcAccount);
            int i = 1 / 0;
            updateAccount(desAccount);
            //3. 提交事务
            manager.commit();
            //4. 返回结果

        } catch (Exception e) {
            //5. 回滚事务
            manager.rollback();
            e.printStackTrace();
        } finally {
            //6. 释放连接
            manager.release();
        }
    }
}
