package com.faq.mapper;

import com.faq.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {
    public List<Department> getDepartment();
}
