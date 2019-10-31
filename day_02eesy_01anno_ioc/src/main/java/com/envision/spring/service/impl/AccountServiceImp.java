package com.envision.spring.service.impl;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.service.IAccountService;
import org.springframework.stereotype.Component;

/**
 * 曾經的xml配置
 * <bean id="accountService" class="com.envision.spring.service.impl.AccountServiceImp">
 *     scope="" init-method="" destroy-method="">
 *     <property name="" value="" / ref=""></property>
 *     </bean>
 *
 * 用于创建对象的
 *      作用就是和在xml配置文件中编写一个<bean></bean>标签实现的功能是一样的
 * @Component
 *      作用：用于把当前类对象存入spring中
 *      属性
 *          value：用于指定bean的ID 默认为类名且首字母小写
 *
 * 用于注入数据的
 *      作用就是和在xml配置文件中bean标签中写一个property标签的作用是一样的
 * 用于改变作用范围的
 *      scope属性
 * 与生命周期相关
 *      init destroy
 *
 *
 *
 * 账户的业务层接口实现类
 */

@Component(value = "accountService")
public class AccountServiceImp implements IAccountService {

    public AccountServiceImp() {
        System.out.println("对象已经创建");
    }

    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
