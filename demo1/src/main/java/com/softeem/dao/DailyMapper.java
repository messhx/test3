package com.softeem.dao;

import com.softeem.pojo.Daily;

import java.util.List;

/**
 * 日志的接口
 */
public interface DailyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Daily daily);

    int insertSelective(Daily daily);

    Daily selectByPrimaryKey(String id);

    int updateByPrimaryKey(Daily daily);

    int updateByPrimaryKeySelective(Daily daily);

    /**
     * 查询某一个学生提交的所有的日志
     * @param sid
     * @return
     */
    List<Daily> selectBySid(Integer sid);
}
