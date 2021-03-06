package com.envision.spring.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.envision.spring.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    @Autowired
    private ConnectionUtil connectionUtil;

    @Override
    public void save(Account account) {
        try {
            runner.update(connectionUtil.getConnection(), "insert into account(name,money)value(?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            runner.update(connectionUtil.getConnection(),"update account set name=?,money=? where id=?", account.getName(), account.getMoney(),
                    account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer accountId) {
        try {
            runner.update(connectionUtil.getConnection(),"delete from account where id=?", accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findById(Integer accountId) {
        try {
            return runner.query(connectionUtil.getConnection(),"select * from account where id=?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findByName(String name) {
        try {
            return runner.query(connectionUtil.getConnection(),"select * from account where name=?", new BeanHandler<>(Account.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> findAll() {
        try {
            return runner.query(connectionUtil.getConnection(),"select * from account ", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
