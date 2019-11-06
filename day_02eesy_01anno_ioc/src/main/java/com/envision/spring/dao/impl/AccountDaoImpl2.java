package com.envision.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.envision.spring.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

     public void saveAccount() {
         System.out.println("save Account successful 2222!");
     }
}
