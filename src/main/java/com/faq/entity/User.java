package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User implements Cloneable{
    private Integer id;
    private String password;
    private String name;
    private String companyName;
    private Integer age;
    private String eMail;
    private String province;
    private String city;
    private String departmentName;
    private Integer departmentId;
    private String tel;
    private String industry;
    private String status;
    private String loginIp;
    //private Timestamp loginTime;
    //private Timestamp registeTime;
    private String registeIp;
    private String pwd;
    private String token;
    private Contract contract;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
