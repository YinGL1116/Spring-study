package com.envision.spring.config;

import com.envision.spring.factory.BeanFactory;
import com.envision.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.envision.spring")
@Import(JDBCConfiguration.class)
public class SpringConfiguration {

    @Autowired
    BeanFactory factory;

    @Bean("proxyAccountService")
    public IAccountService getAccountService() {
        return factory.getAccountService();
    }

}
