package com.envision.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.envision.spring.config.SpringConfiguration;
import com.envision.spring.domain.Account;
import com.envision.spring.service.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {

    @Autowired
    IAccountService accountService;

    @Test
    public void findAllTest() {

        accountService.findAllAccount().forEach(System.out::println);
    }

    @Test
    public void findOneByIdTest() {

        System.out.println(accountService.findAccountById(1));
    }

    @Test
    public void saveTest() {
        Account account = new Account(4, "my", 1000f);
        accountService.saveAccount(account);
    }

    @Test
    public void transferTest() {
        accountService.transfer("aaa", "bbb", 100);
    }

    @Test
    public void updateTest() {
        Account account = accountService.findAccountById(1);
        account.setMoney(account.getMoney() + 200f);

        accountService.updateAccount(account);
    }
}
