package com.softeem.controller;

import com.softeem.pojo.Student;
import com.softeem.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@RequestMapping("/stu")
@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/reg")
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

    @RequestMapping("/login")
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