package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface DepartmentService {
    Vo<Department> selectAllDepartment(int page, int rows);

    int insertSelective(Department record);

    int updateByPrimaryKeySelective(Department record);

    Vo<Department> fuzzySelectById(String departmentId,int page, int rows);

    Vo<Department> fuzzySelectByname(String departmentName, int page, int rows);

    int deleteByIds(String[] ids);

    Department selectByPrimaryKey(String departmentId);


    List<Department> showAllDepartment();
}
