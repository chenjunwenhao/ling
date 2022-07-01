package com.faq.service;

import com.faq.entity.Recruit;

import java.util.List;


public interface RecruitService {

    public List<Recruit> getRecruit(Recruit recruit);
    public Recruit getRecruitById(Recruit recruit);
    public int insertRecruit(Recruit recruit);
    public int updateRecruit(Recruit recruit);
    public int deleteRecruit(Recruit recruit);
}
