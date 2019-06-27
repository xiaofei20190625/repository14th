package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.vo.ResponseVo;
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

    /*提交增加部门，返回json的结果*/
    @RequestMapping("department/insert")
    @ResponseBody
    public ResponseVo submitAddDepartment(String departmentId, String departmentName, String note, String departmentParams) {
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setNote(note);
        int i = departmentService.insertSelective(department);
        if (i == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }

    }

    /*转到编辑部门的页面*/
    @RequestMapping("department/edit")
    public String editDepartmentPage() {

        return "department_edit";
    }

    /*返回编辑部门页面的json数据*/
    @RequestMapping("department/edit_judge")
    @ResponseBody
    public String returnToeditDepartment() {
        return null;
    }

    /*提交增加部门，返回json的结果*/
    @RequestMapping("department/update_all")
    @ResponseBody
    public ResponseVo submiteditDepartment(String departmentId, String departmentName, String note) {
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setNote(note);
        int update = departmentService.updateByPrimaryKeySelective(department);
        if (update == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }
    }
    /*根据部门编号搜索部门，返回json数据*/
    @RequestMapping("department/search_department_by_departmentId")
    @ResponseBody
    public Vo<Department> fuzzySerchById(String searchValue, int page, int rows) {
        return departmentService.fuzzySelectById(searchValue, page, rows);
    }

    /*根据部门名搜索部门，返回json数据*/
    @RequestMapping("department/search_department_by_departmentName")
    @ResponseBody
    public Vo<Department> fuzzySerchByname(String searchValue, int page, int rows) {
        return departmentService.fuzzySelectByname(searchValue, page, rows);
    }

    //删除部门，返回json数据
    @RequestMapping("department/delete_judge")
    @ResponseBody
    public String deleteDepartment() {
        return null;
    }

    //执行删除部门，返回执行结果的json数据
    @RequestMapping("department/delete_batch")
    @ResponseBody
    public ResponseVo doDeleteDepartmentById(String[] ids) {
        int delete = departmentService.deleteByIds(ids);
        if (delete > 0) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }
    }




}
