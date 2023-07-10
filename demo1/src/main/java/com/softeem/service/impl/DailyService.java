package com.softeem.service.impl;

import com.softeem.dao.DailyMapper;
import com.softeem.dao.StudentMapper;
import com.softeem.pojo.Daily;
import com.softeem.pojo.DailyInfo;
import com.softeem.pojo.Student;
import com.softeem.service.IDailyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

//1、添加注解将service添加到系统中
@Service
public class DailyService implements IDailyService {
    //2、自动装载两个mapper
    //@Autowired//type
    @Resource//name
    private DailyMapper dailyMapper;
    @Resource
    private StudentMapper studentMapper;

    /**
     * 添加日志
     * @param daily
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean add(Daily daily) {
        //根据uuid1生成一个id值
        daily.setId(UUID.randomUUID().toString());
        //设置提交的时间
        daily.setSubtime(new Date());
        return dailyMapper.insertSelective(daily) > 0;
    }

    /**
     * 根据日志的id查询日志的内容以及提交日志的学生的相关信息
     * @param id
     * @return
     */
    @Override
    public DailyInfo queryById(String id) {
        //创建一个包含了学生类和日志类的业务层处理类对象
        //现在只用基于日志进行处理的一部分
        DailyInfo dailyInfo = null;
        //根据日志id查询日志对象
        Daily daily = dailyMapper.selectByPrimaryKey(id);
        //如果对象不为空
        if(Objects.nonNull(daily)){
            //根据学号查询学生信息
            Student student = studentMapper.selectByPrimaryKey(daily.getSid());
            dailyInfo = new DailyInfo(daily,student);
        }
        return dailyInfo;
    }

    @Override
    public List<DailyInfo> queryBySid(Integer id) {
        //用来存储学生信息和他的日志信息
        List<DailyInfo> dailys = new ArrayList<>();
        //根据学号来查询学生对象
        Student student = studentMapper.selectByPrimaryKey(id);
        //根据序号查询所有的日报
        List<Daily> list = dailyMapper.selectBySid(id);

        //遍历集合并且将集合中的数据传给dailys中
        //参数d是我们遍历出来的每一个日志
        list.stream().forEach((d)->{
            dailys.add(new DailyInfo(d,student));
        });

        return dailys;
    }

    @Override
    public List<DailyInfo> queryToday() {
        return null;
    }
}
