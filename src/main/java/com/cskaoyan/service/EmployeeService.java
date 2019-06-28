package com.cskaoyan.service;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface EmployeeService {

    Vo<EmployeeResponse> queryAllEmployee(int page, int rows);

    int insertSelective(Employee record);

    int updateByPrimaryKeySelective(Employee employee);

    int deleteEmployeeByIds(String[] ids);

    List<EmployeeResponse> queryAllEmployee();

    EmployeeResponse selectByPrimaryKey(String empId);

    Vo<EmployeeResponse> fuzzyQueryByEmployeeId(String empId, int page, int rows);

    Vo<EmployeeResponse> fuzzyQueryByEmployeeName(String empName, int page, int rows);

    Vo<EmployeeResponse> fuzzyQueryByDepartmentName(String departmentName, int page, int rows);

}
