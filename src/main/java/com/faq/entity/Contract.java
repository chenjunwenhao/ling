package com.faq.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Contract {
    private Integer id;
    private Integer userId;
    private Integer age;
    private Integer workYears;
    private String idCard;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;
    private Integer contractTerm;
    private Double salary;
    private String post;
    private String remark;
    private char delFlag;

    private String userName;
    private String industry;
    private String tel;
    private String departmentName;
    private Integer departmentId;
}
