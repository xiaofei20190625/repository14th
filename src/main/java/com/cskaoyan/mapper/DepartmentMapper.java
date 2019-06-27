package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    List<Department> selectAllDepartment();

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}