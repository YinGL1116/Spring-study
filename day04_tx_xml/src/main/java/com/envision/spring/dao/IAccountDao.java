package com.envision.spring.dao;

import com.envision.spring.domain.Account;

import java.util.List;

public interface IAccountDao {

    void update(Account account);

    Account findById(Integer accountId);

    Account findByName(String name);
}
