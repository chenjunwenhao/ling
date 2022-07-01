package com.faq.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LHan {
    private static LHan instance;
    private LHan(){};
    private static LHan getInstance(){
        if(instance==null){
             instance = new LHan();
        }
        return instance;
    }

}
