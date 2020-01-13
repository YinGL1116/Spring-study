package com.envision.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.envision.spring.CDPlayer;
import com.envision.spring.CompactDisc;
import com.envision.spring.JayCD;

@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc jayCD() {
        return new JayCD();
    }

    /*
     * @Bean public CDPlayer cdPlayer() { return new CDPlayer(); }
     */

    // 验证了一下带@Bean方法创建bean的时候可以实现自动注入参数
    @Bean
    public CDPlayer cdPlayer(CompactDisc disc) {
        return new CDPlayer(disc);
    }
}
