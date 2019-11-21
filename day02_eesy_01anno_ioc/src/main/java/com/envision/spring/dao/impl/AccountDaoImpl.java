package com.envision.spring.dao.impl;

import com.envision.spring.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

     public void saveAccount() {
         System.out.println("save Account successful!");
     }
}
