package com.softeem.studentdaily.dao;


import com.softeem.studentdaily.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生的接口
 */
@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student student);

    int insertSelective(Student student);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Student student);

    int updateByPrimaryKeySelective(Student student);

    Student selectByPhone(String phone);
}
