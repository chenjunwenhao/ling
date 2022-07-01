package com.faq.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@lombok.Data
@Component
public class Data {
    private Integer dataId;
    private String dataName;
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp dataTime;
    private String dataContact;
    private String dataFile;
    private String dataSuffix;
    private String dataType;
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    private Integer createBy;
//    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;
    private Integer updateBy;
    private String remark;
    private Character delFlag;

}
