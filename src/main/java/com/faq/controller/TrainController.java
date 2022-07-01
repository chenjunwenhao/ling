package com.faq.controller;

import com.faq.entity.Train;
import com.faq.service.TrainService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    private TrainService trainService;
    @RequestMapping("/getTrain")
    public PageInfo<Train> getTrain(Train train, Integer pageIndex, Integer pageSize){
        List<Train> list = new ArrayList<>();
        Page<Train> page = PageHelper.startPage(pageIndex,pageSize);
        list =trainService.getTrain(train);
        PageInfo<Train> pageInfo= new PageInfo<Train>(list);
        return pageInfo;
    }
    @RequestMapping("/getTrainById")
    public Train getTrainById(Train train){
        return trainService.getTrainById(train);
    }
    @RequestMapping("/save")
    public String save(Train train){
        if(train.getId()==null){
            if(trainService.insertTrain(train)==1){
                return "success";
            }
            return  "insertFail";
        }
        int status = trainService.updateTrain(train);
        if(status==1){
            return "success";
        }
        return "updateFail";
    }
    @RequestMapping("update")
    public String update(Train train){
        int status = trainService.updateTrain(train);
        if(status==1){
            return "success";
        }
        return "fail";
    }
    @RequestMapping("delete")
    public String delete(Train train){
        int status = trainService.deleteTrain(train);
        if(status==1){
            return "success";
        }
        return "fail";
    }
}
