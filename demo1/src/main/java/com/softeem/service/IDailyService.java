package com.softeem.service;

import com.softeem.pojo.Daily;
import com.softeem.pojo.DailyInfo;

import java.util.List;

public interface IDailyService {
    /**
     * 添加日报
     * @param daily
     * @return
     */
    boolean add(Daily daily);

    /**
     * 根据id查询日报
     * @param id
     * @return
     */
    DailyInfo queryById(String id);

    /**
     * 查询指定学生提交的所有日报
     * @param id
     * @return
     */
    List<DailyInfo> queryBySid(Integer id);

    /**
     * 查询今天提交的所有的日报
     * @return
     */
    List<DailyInfo> queryToday();
}
