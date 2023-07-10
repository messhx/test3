package com.softeem.studentdaily.service;


import com.softeem.studentdaily.pojo.Student;

public interface IStudentService {

    boolean reg(Student student);

    Student login(String phone);
}
