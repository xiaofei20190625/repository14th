package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public Vo<EmployeeResponse> queryAllEmployee(int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);
        //查询数据
        List<EmployeeResponse> employeeResponses = employeeMapper.queryAllEmployee();
        PageInfo<EmployeeResponse> pageInfo = new PageInfo<>(employeeResponses);
        //封装成vo
        Vo<EmployeeResponse> employeeResponseVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return employeeResponseVo;
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public int deleteEmployeeByIds(String[] ids) {
        return employeeMapper.deleteEmployeeByIds(ids);
    }

    @Override
    public Vo<EmployeeResponse> fuzzyQueryByEmployeeId(String empId, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<EmployeeResponse> employeeResponses = employeeMapper.fuzzyQueryByEmployeeId(empId);
        PageInfo<EmployeeResponse> pageInfo = new PageInfo<>(employeeResponses);
        Vo<EmployeeResponse> employeeResponseVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return employeeResponseVo;
    }

    @Override
    public Vo<EmployeeResponse> fuzzyQueryByEmployeeName(String empName, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<EmployeeResponse> employeeResponses = employeeMapper.fuzzyQueryByEmployeeName(empName);
        PageInfo<EmployeeResponse> pageInfo = new PageInfo<>(employeeResponses);
        Vo<EmployeeResponse> employeeResponseVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return employeeResponseVo;
    }

    @Override
    public Vo<EmployeeResponse> fuzzyQueryByDepartmentName(String departmentName, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<EmployeeResponse> employeeResponses = employeeMapper.fuzzyQueryByDepartmentName(departmentName);
        PageInfo<EmployeeResponse> pageInfo = new PageInfo<>(employeeResponses);
        Vo<EmployeeResponse> employeeResponseVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return employeeResponseVo;
    }

    @Override
    public EmployeeResponse selectByPrimaryKey(String empId) {
        return employeeMapper.selectByPrimaryKey(empId);
    }

    @Override
    public List<EmployeeResponse> queryAllEmployee() {
        return employeeMapper.queryAllEmployee();
    }
}
