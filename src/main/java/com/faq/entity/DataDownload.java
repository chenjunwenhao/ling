package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Data
@Component
public class DataDownload {
    private Integer downloadId;
    private Integer dataId;
    private Integer userId;
    private String dataName;
    private String userName;
    private Timestamp downloadTime;
    private int downloadNum;
    private String downloadIp;
    private Timestamp createTime;
    private Integer createBy;
    private Timestamp updateTime;
    private Integer updateBy;
    private String remark;
    private Character delFlag;
}
