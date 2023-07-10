package com.softeem.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Daily implements Serializable {
    private String id;
    private String gain;
    private String question;
    private String suggest;
    private Date subtime;
    private Date lastupdatetime;
    private Integer sid;
}
