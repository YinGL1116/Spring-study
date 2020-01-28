package com.envision.spring.service.impl;

import com.envision.spring.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Override
    public void save() {
        System.out.println("执行了保存");
    }

    @Override
    public void update(int i) {
        System.out.println("执行了更新");
    }

    @Override
    public int delete() {
        System.out.println("执行了删除");
        return 0;
    }
}
