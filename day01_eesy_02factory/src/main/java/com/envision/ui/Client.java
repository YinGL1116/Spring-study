package com.envision.ui;

import com.envision.factory.BeanFactory;
import com.envision.service.IAccountService;
import com.envision.service.impl.AccountServiceImp;

public class Client {

    public static void main(String[] args) {

        //存在类之间的依赖 尽量避免这种依赖以降低程序间的耦合
        //IAccountService accountService = new AccountServiceImp();
        //IAccountService accountService = (IAccountService)BeanFactory.getBean("accountService");
        //accountService.saveAccount();

        //单实例
        for (int i = 0; i < 5; i++) {
            IAccountService accountService = (IAccountService)BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
