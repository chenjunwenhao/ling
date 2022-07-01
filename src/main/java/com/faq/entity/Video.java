package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Data
@Component
public class Video {
    private Integer videoId;
    private String videoName;
    private String videoContact;
    private String videoType;
    private String videoFile;
    private String videoImg;
    private Timestamp videoTime;
    private Timestamp createTime;
    private Integer createBy;
    private Timestamp updateTime;
    private Integer updateBy;
    private String remark;
    private Character delFlag;
}
