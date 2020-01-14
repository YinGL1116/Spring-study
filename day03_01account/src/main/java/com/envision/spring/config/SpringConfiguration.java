package com.envision.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.envision.spring")
@Import(JDBCConfiguration.class)
public class SpringConfiguration {

}
