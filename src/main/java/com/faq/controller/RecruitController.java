package com.faq.controller;

import com.faq.entity.Recruit;
import com.faq.service.RecruitService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;
    @RequestMapping("/getRecruit")
    public PageInfo<Recruit> getRecruit(Recruit recruit, Integer pageIndex, Integer pageSize){
        List<Recruit> list = new ArrayList<>();
        Page<Recruit> page = PageHelper.startPage(pageIndex,pageSize);
        list =recruitService.getRecruit(recruit);
        PageInfo<Recruit> pageInfo= new PageInfo<Recruit>(list);
        return pageInfo;
    }
    @RequestMapping("/getRecruitById")
    public Recruit getRecruitById(Recruit recruit){
        return recruitService.getRecruitById(recruit);
    }
    @RequestMapping("/save")
    public String save(Recruit recruit){
        if(recruit.getId()==null){
            if(recruitService.insertRecruit(recruit)==1){
                return "success";
            }
            return  "insertFail";
        }
        int status = recruitService.updateRecruit(recruit);
        if(status==1){
            return "success";
        }
        return "updateFail";
    }
    @RequestMapping("update")
    public String update(Recruit recruit){
        int status = recruitService.updateRecruit(recruit);
        if(status==1){
            return "success";
        }
        return "fail";
    }
    @RequestMapping("delete")
    public String delete(Recruit recruit){
        int status = recruitService.deleteRecruit(recruit);
        if(status==1){
            return "success";
        }
        return "fail";
    }
}
