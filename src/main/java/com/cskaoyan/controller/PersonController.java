package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    DepartmentService departmentService;

    /*转到显示部门页面*/
    @RequestMapping("department/find")
    public String findDepartment() {
        /*List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("department:add");
        sysPermissionList.add("department:edit");
        sysPermissionList.add("'department:delete'");
        session.setAttribute("sysPermissionList", sysPermissionList);*/
        return "department_list";
    }



    /*返回显示部门页面的json数据*/
    @RequestMapping("department/list")
    @ResponseBody
    public List<Department> returnDepartment() {
        List<Department> departments = departmentService.selectAllDepartment();
        return departments;
    }

    /*新增部门返回值，因为不需要返回值所有返回null*/
    @RequestMapping("department/add_judge")
    @ResponseBody
    public String addDepartment() {
        return null;
    }

    /*新增部门返回值，因为不需要返回值所有返回null*/
    @RequestMapping("department/add")
    public String showaddDepartment() {
        return "department_add";
    }





}
