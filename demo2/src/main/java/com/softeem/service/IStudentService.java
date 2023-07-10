package com.softeem.service;

import com.softeem.pojo.Student;

public interface IStudentService {

    boolean reg(Student student);

    Student login(String phone);
}
