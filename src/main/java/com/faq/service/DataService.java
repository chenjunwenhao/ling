package com.faq.service;

import com.faq.entity.Data;

import java.util.List;

public interface DataService {
    public List<Data> getData(Data data);
    public Data getDataById(Data data);
    public int insert(Data data);
    public int update(Data data);
    public int delete(Data data);
}
