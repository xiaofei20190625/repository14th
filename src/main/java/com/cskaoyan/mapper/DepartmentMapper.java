package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int deleteByIds(String[] ids );

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    List<Department> selectAllDepartment();

    List<Department> fuzzySelectById(String departmentId);

    List<Department> fuzzySelectByname(String departmentName);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> showAllDepartment();
}