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
}
