package com.softeem.studentdaily.controller;


import com.softeem.studentdaily.pojo.Daily;
import com.softeem.studentdaily.pojo.DailyInfo;
import com.softeem.studentdaily.service.IDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/daily")
@Controller
public class DailyController {
    @Autowired
    private IDailyService dailyService;

    @RequestMapping("/add")
    public ModelAndView dailySubmit(Daily daily){
        boolean f = dailyService.add(daily);
        return new ModelAndView("result","stat",f);
    }

    /**
     * 通过学生id来查找他提交过得所有的信息
     * @param sid
     * @return
     */
    @RequestMapping("/queryBySid")
    public ModelAndView queryBySid(Integer sid){
        List<DailyInfo> list = dailyService.queryBySid(sid);
        return new ModelAndView("main","list",list);
    }

    /**
     * 根据日志id来查询日志
     * @param id
     * @return
     */
    @RequestMapping("/queryById")
    public ModelAndView queryById(String id){
        DailyInfo info = dailyService.queryById(id);
        return new ModelAndView("result","daily",info);
    }
}
