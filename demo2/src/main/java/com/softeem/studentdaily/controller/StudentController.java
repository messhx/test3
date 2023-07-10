package com.softeem.studentdaily.controller;


import com.softeem.studentdaily.pojo.Student;
import com.softeem.studentdaily.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;



@Controller

public class StudentController {
    @Resource
    private IStudentService studentService;

    @GetMapping("/stu/reg")
    public ModelAndView reg(Student student){
        ModelAndView mv = new ModelAndView();
        boolean flag = studentService.reg(student);
        if(flag){
            mv.setViewName("login");
        }else{
            mv.setViewName("reg");
        }
        return mv;
    }

    @GetMapping("/stu/login")
    public String login(String phone,String password){
        String str = "";
        Student student = studentService.login(phone);
        if(Objects.nonNull(student)){
            if(student.getPassword().equals(password)){
                str = "redirect:daily/queryBySid";
            }else{
                str = "redirect:login";
            }
        }else{
            str = "redirect:reg";
        }
        return str;
    }
}