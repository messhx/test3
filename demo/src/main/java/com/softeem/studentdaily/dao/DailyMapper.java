package com.softeem.studentdaily.dao;



import com.softeem.studentdaily.pojo.Daily;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 日志的接口
 */
@Mapper
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
