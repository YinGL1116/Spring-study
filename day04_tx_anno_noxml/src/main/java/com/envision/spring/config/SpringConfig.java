package com.envision.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.envision.spring")
@Import({JdbcConfig.class, TransactionManagerConfig.class})
@EnableTransactionManagement
public class SpringConfig {

}
