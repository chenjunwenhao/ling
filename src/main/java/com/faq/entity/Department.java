package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Department {
    private Integer id;
    private String name;
}
