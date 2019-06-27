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
        return "department_list";
    }



    /*返回显示部门页面的json数据*/
    @RequestMapping("department/list")
    @ResponseBody
    public List<Department> returnDepartment() {
        List<Department> departments = departmentService.selectAllDepartment();
        return departments;
    }


}
