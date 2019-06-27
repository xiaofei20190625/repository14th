package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface DepartmentService {
    Vo<Department> selectAllDepartment(int page, int rows);

    int insertSelective(Department record);
}
