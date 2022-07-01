package com.faq.mapper;

import com.faq.entity.Recruit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecruitDao {

    public List<Recruit> getRecruit(Recruit recruit);
    public Recruit getRecruitById(Recruit recruit);
    public int insertRecruit(Recruit recruit);
    public int updateRecruit(Recruit recruit);
    public int deleteRecruit(Recruit recruit);
}
