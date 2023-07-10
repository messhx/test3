package com.softeem.studentdaily.service.impl;


import com.softeem.studentdaily.dao.StudentMapper;
import com.softeem.studentdaily.pojo.Student;
import com.softeem.studentdaily.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StudentService implements IStudentService {

    @Resource
    private StudentMapper studentMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean reg(Student student) {
        student.setRegtime(new Date());
        return studentMapper.insert(student) > 0;
    }

    @Override
    public Student login(String phone) {
        Student student = studentMapper.selectByPhone(phone);
        System.out.println("student:" + student);
        return student;
    }
}
