package com.envision.spring.dao.impl;

import com.envision.spring.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

     public void saveAccount() {
         System.out.println("save Account successful!");
     }
}
