package com.envision.spring.config;

import com.envision.spring.factory.BeanFactory;
import com.envision.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.envision.spring")
@Import(JDBCConfiguration.class)
@EnableAspectJAutoProxy
public class SpringConfiguration {

    @Autowired
    BeanFactory factory;

    @Bean("proxyAccountService")
    public IAccountService getAccountService() {
        return factory.getAccountService();
    }

}
