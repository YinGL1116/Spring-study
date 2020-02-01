package com.envision.spring.service;

import com.envision.spring.domain.Account;

import java.util.List;

public interface IAccountService {

    Account findAccountById(Integer accountId);

    void transfer(String src, String des, float money);
}
