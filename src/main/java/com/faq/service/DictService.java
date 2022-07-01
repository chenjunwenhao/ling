package com.faq.service;

import com.faq.entity.Department;
import com.faq.entity.Dict;

import java.util.List;

public interface DictService {
    public List<Dict> getProvince();
    public List<Dict> getCity(Dict dict);
    public List<Department> getDepartment();
}
