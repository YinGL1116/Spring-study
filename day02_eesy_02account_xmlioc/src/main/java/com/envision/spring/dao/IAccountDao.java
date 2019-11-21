package com.envision.spring.dao;

import com.envision.spring.domain.Account;

import java.util.List;

public interface IAccountDao {

    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
