package com.envision.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.envision.spring.domain.Student;

@Component
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        String sql = "select * from student";
        // RowMapper对象 用于接收从ResultSet中返回的数据 //也可以自定义实现方式
        // RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);

        return jdbcTemplate.query(sql, new StudentRowMapper());

    }

    private static final class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"),
                    resultSet.getDate("birthday"));
        }
    }

}
