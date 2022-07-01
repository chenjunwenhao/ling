package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Train {
    private Integer id;
    private String trainName;
    private String trainUser;
    private String trainContent;
    private String trainPlace;
    private String trainTime;
    private String userId;
    private String remark;
    private char delFlag;
}
