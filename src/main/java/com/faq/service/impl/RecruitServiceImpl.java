package com.faq.service.impl;

import com.faq.entity.Recruit;
import com.faq.mapper.RecruitDao;
import com.faq.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;
    @Override
    public List<Recruit> getRecruit(Recruit recruit){return recruitDao.getRecruit(recruit);};
    @Override
    public Recruit getRecruitById(Recruit recruit){return recruitDao.getRecruitById(recruit);};
    @Override
    public int insertRecruit(Recruit recruit){return recruitDao.insertRecruit(recruit);};
    @Override
    public int updateRecruit(Recruit recruit){return recruitDao.updateRecruit(recruit);};
    @Override
    public int deleteRecruit(Recruit recruit){return recruitDao.deleteRecruit(recruit);};
}
