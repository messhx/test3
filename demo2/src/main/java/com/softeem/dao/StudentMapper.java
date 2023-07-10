package com.softeem.dao;

import com.softeem.pojo.Student;

/**
 * 学生的接口
 */
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student student);

    int insertSelective(Student student);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Student student);

    int updateByPrimaryKeySelective(Student student);

    Student selectByPhone(String phone);
}
