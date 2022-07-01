package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dict {
    private int id;
    private String label;
    private String value;
    private String type;
    private  int parentId;
}
