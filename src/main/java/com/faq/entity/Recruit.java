package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Recruit {
    private Integer id;
    private String recruitName;
    private String recruitTime;
    private String recruitContent;
    private char delFlag;
}
