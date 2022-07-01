package com.faq.controller;

import com.faq.entity.Contract;
import com.faq.service.ContractService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @RequestMapping("/inputContract")
    public String inputContract(Contract contract){

        Contract contactByUserId = contractService.getContractByUserId(contract);
        if(contactByUserId==null){
            return "success";
        }else{
            return "fail";
        }
    }
    @RequestMapping("/insertContract")
    public String insertContract(Contract contract){
        int isInsertContract = contractService.insertContract(contract);
        if(isInsertContract==1){
            return "success";
        }else {
            return "fail";
        }
    }
    @RequestMapping("/getContract")

    public PageInfo<Contract> getContract(Contract contract, Integer pageIndex, Integer pageSize){
        //redisUtil.lSet("uname",0,"aaa");
        //redisUtil.incrBy("num",1);
        //System.out.print(redisUtil.get("num")+"=====================================================");
        List<Contract> list = new ArrayList<>();
        Page<Contract> page = PageHelper.startPage(pageIndex,pageSize);
        list =contractService.getContractList(contract);
        PageInfo<Contract> pageInfo= new PageInfo<Contract>(list);
        return pageInfo;
    }
}
