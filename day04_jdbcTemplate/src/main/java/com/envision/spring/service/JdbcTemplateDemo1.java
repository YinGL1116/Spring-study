package com.envision.spring.service;

import com.envision.spring.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //spring 自带的数据源
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("guoliang5388");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        jdbcTemplate.execute("insert into account(name, money) values('test', 1000)");*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");

        //保存 更新 删除 都可以使用 update方法 可以替换sql语句参数

        //查询 使用query方法
     /*   List<Account> accounts = jdbcTemplate.query("select * from account", new RowMapper<Account>() {
            //实现RowMapper接口中的方法  也可以使用内部类的方式实现
            //对结果集进行再处理 提取 使之符合期望
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setName(rs.getString("name"));
                account.setMoney(rs.getFloat("money"));
                return account;
            }
        });*/
        //或者可以使用BeanPropertyRowMapper<>(...class)
//        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
//        accounts.forEach(System.out::println);

        Long count = jdbcTemplate.queryForObject("select count(*) from account where money>?", Long.class, 500f);
        System.out.println(count);
    }
}
