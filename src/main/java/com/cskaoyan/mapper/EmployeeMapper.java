package com.cskaoyan.mapper;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeResponse;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    EmployeeResponse selectByPrimaryKey(String empId);

    List<EmployeeResponse> queryAllEmployee();

    List<EmployeeResponse> fuzzyQueryByEmployeeId(String empId);

    List<EmployeeResponse> fuzzyQueryByEmployeeName(String empName);

    List<EmployeeResponse> fuzzyQueryByDepartmentName(String departmentName);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int deleteEmployeeByIds(String[] ids);
}