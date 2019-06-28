package com.cskaoyan.service;

import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.vo.Vo;

public interface EmployeeService {

    Vo<EmployeeResponse> queryAllEmployee(int page, int rows);
}
