package com.envision.spring.config;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:/jdbc.properties")
public class JDBCConfiguration {

    @Value("${jdbc.driverClass}")
    String driverClass;
    @Value("${jdbc.Url}")
    String url;
    @Value("${jdbc.user}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean("dataSource")
    public DataSource creatDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Bean("runner")
    public QueryRunner creatQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

}
