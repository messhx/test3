package com.softeem.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * 用于业务层数据传输的对象
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DailyInfo implements Serializable {
    private Daily daily;
    private Student student;
}
