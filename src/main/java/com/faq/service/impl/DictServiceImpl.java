package com.faq.service.impl;

import com.faq.entity.Department;
import com.faq.entity.Dict;
import com.faq.mapper.DictDao;
import com.faq.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典service
 */
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictDao dictDao;

    /**
     * 取得所有省级地区
     * @return
     */
    @Override
    public List<Dict> getProvince(){
        return dictDao.getProvince();
    }

    /**
     * 取得对应的市级地区
     * @param dict
     * @return
     */
    @Override
    public List<Dict> getCity(Dict dict){
        return dictDao.getCity(dict);
    }

    /**
     * 取得所有部门，加入到字典里了
     * @return
     */
    @Override
    public List<Department> getDepartment(){ return  dictDao.getDepartment();}
}
