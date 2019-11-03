package com.envision.spring.service.impl;

import com.envision.spring.dao.IAccountDao;
import com.envision.spring.service.IAccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 曾經的xml配置
 * <bean id="accountService" class="com.envision.spring.service.impl.AccountServiceImp">
 *     scope="" init-method="" destroy-method="">
 *     <property name="" value="" / ref=""></property>
 *     </bean>
 *
 * 用于创建对象的
 *      作用就是和在xml配置文件中编写一个<bean></bean>标签实现的功能是一样的
 *      @Component
 *      作用：
 *          用于把当前类对象存入spring中
 *      属性
 *          value：用于指定bean的ID 默认为类名且首字母小写
 *      @Controller 表现层
 *      @Service 业务层
 *      @Repository 持久层
 *
 *      以上三个注解的属性和作用是和Component一样的。只是为了区分层次而已
 *
 *
 * 用于注入数据的
 *      作用就是和在xml配置文件中bean标签中写一个property标签的作用是一样的
 *      @Autowired
 *          作用：
 *              自动按照类型注入，只要容器中有唯一的一个bean对象和要注入的对象类型匹配
 *              如果ioc容器里 没有匹配的类型 报错
 *              如果有多个 则根据要《注入类型的变量名》的查找 找到再注入 否则报错
 *          出现位置：
 *              可以为变量 可以是方法
 *          细节：
 *              使用注解注入 不用set方法
 *
 *          注意：先 byType 不行再byName
 *
 *
 * 用于改变作用范围的
 *      scope属性
 * 与生命周期相关
 *      init destroy
 *
 *
 *
 * 账户的业务层接口实现类
 */

@Service(value = "accountService")
public class AccountServiceImp implements IAccountService {

    public AccountServiceImp() {
        System.out.println("对象已经创建");
    }

    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
