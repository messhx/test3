package com.softeem.studentdaily.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private Integer sid;
    private String name;
    private String phone;
    private String password;
    private String sex;
    private Date regtime;
}
