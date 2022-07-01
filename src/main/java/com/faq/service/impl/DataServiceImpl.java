package com.faq.service.impl;

import com.faq.entity.Data;
import com.faq.mapper.DataDao;
import com.faq.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService{
    @Autowired
    private DataDao dataDao;

    @Override
    public List<Data> getData(Data data){
        return dataDao.getData(data);
    }
    @Override
    public Data getDataById(Data data){
        return  dataDao.getDataById(data);
    }
    @Override
    public int insert(Data data){
        return  dataDao.insert(data);
    }
    @Override
    public int update(Data data){
        return  dataDao.update(data);
    }
    @Override
    public int delete(Data data){
        return  dataDao.delete(data);
    }
}
