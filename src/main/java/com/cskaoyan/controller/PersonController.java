package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.vo.AddDepartmentResult;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Vo<Department> returnDepartment(int page, int rows) {
        Vo<Department> departmentVo = departmentService.selectAllDepartment(page, rows);
        return departmentVo;
    }

    /*转到增加部门的页面*/
    @RequestMapping("department/add")
    public String addDepartmentPage() {
        return "department_add";
    }

    /*返回增加部门页面的json数据*/
    @RequestMapping("department/add_judge")
    @ResponseBody
    public String returnToaddDepartment() {
        return null;
    }

    /*提交增加部门*/
    @RequestMapping("department/insert")
    @ResponseBody
    public AddDepartmentResult submitAddDepartment(String departmentId, String departmentName, String note, String departmentParams) {
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setNote(note);
        int i = departmentService.insertSelective(department);
        if (i == 1) {
            AddDepartmentResult addDepartmentResult = new AddDepartmentResult();
            addDepartmentResult.setStatus(200);
            addDepartmentResult.setMsg("OK");
            addDepartmentResult.setData(null);
            return addDepartmentResult;
        } else {
            return null;
        }

    }


}
