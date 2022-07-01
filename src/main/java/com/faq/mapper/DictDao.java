package com.faq.mapper;

import com.faq.entity.Department;
import com.faq.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictDao {

   public List<Dict> getProvince();
   public List<Dict> getCity(Dict dict);
   public List<Department> getDepartment();

}
