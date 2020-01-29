package com.envision.spring.dao;

import com.envision.spring.domain.Account;

import java.util.List;

public interface IAccountDao {

    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    Account findByName(String name);

    List<Account> findAll();
}
