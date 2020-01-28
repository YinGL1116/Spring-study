package com.envision.spring.cofig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.envision.spring")
@EnableAspectJAutoProxy
public class SpringConfig {
}
