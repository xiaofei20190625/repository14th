package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Vo<Department> selectAllDepartment(int page, int rows) {
        /*开启分页*/
        PageHelper.startPage(page, rows);
        /*查询数据*/
        List<Department> departments = departmentMapper.selectAllDepartment();
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        /*封装成vo*/
        Vo<Department> departmentVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return departmentVo;
    }

    @Override
    public int insertSelective(Department record) {
        return departmentMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Vo<Department> fuzzySelectById(String departmentId, int page, int rows) {
        /*开启分页*/
        PageHelper.startPage(page, rows);
        /*查询数据*/
        List<Department> departments = departmentMapper.fuzzySelectById("%" + departmentId + "%");
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        Vo<Department> departmentVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return departmentVo;
    }

    @Override
    public Vo<Department> fuzzySelectByname(String departmentName, int page, int rows) {
        /*开启分页*/
        PageHelper.startPage(page, rows);
        List<Department> departments = departmentMapper.fuzzySelectByname("%" + departmentName + "%");
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        Vo<Department> departmentVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return departmentVo;
    }

    @Override
    public int deleteByIds(String[] ids) {
        return departmentMapper.deleteByIds(ids);
    }

    @Override
    public Department selectByPrimaryKey(String departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }
}
