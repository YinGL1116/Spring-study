package com.envision.spring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.envision.spring.domain.Student;
import com.envision.spring.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/*.xml" })
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test() {
        List<Student> list = studentService.findAll();
        for (Student student : list) {
            System.out.println(student);
        }

    }
}
