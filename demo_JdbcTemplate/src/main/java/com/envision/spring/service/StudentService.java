package com.envision.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envision.spring.dao.StudentDao;
import com.envision.spring.domain.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
