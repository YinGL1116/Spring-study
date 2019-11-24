package com.envision.spring.service;

import java.util.List;

import com.envision.spring.domain.Account;

public interface IAccountService {

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findAccountById(Integer accountId);

    List<Account> findAllAccount();
}
