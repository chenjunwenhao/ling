package com.faq.controller;

import com.faq.entity.Department;
import com.faq.entity.Dict;
import com.faq.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * 字典Controller
 */
@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 获得所有省级地区
     * @return
     */
    @RequestMapping("/getProvince")
    public List<Dict> getProvince(){
        return dictService.getProvince();
    }

    /**
     * 获得所有市级地区
     * @param province
     * @return
     */
    @RequestMapping("/getCity")
    public List<Dict> getCity(int province){
        Dict dict = new Dict();
        dict.setParentId(province);
        return dictService.getCity(dict);
    }

    /**
     * 获得所有部门
     * @return
     */
    @RequestMapping("/getDepartment")
    public List<Department> getDepartment(){
        return dictService.getDepartment();
    }
}
