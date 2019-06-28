package com.cskaoyan.service;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.vo.Vo;

public interface EmployeeService {

    Vo<EmployeeResponse> queryAllEmployee(int page, int rows);

    int insertSelective(Employee record);
}
