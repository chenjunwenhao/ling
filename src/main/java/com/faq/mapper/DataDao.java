package com.faq.mapper;

import com.faq.entity.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataDao {
    public List<Data> getData(Data data);
    public Data getDataById(Data data);
    public int insert(Data data);
    public int update(Data data);
    public int delete(Data data);
}
