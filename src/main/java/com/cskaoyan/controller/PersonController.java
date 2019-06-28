package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

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

    /*----------------------以上是department,以下是employee--------------------------------*/

    //查询员工列表,返回到列表的jsp页面
    @RequestMapping("employee/find")
    public String findEmployee() {
        return "employee_list";
    }

    //执行查询员工，返回员工的json数据
    @RequestMapping("employee/list")
    @ResponseBody
    public Vo<EmployeeResponse> returnEmployeeVo(int page, int rows) {
        Vo<EmployeeResponse> employeeResponseVo = employeeService.queryAllEmployee(page, rows);
        return employeeResponseVo;
    }

    //查询员工时，点击部门进行回显
    @RequestMapping("department/get/{myid}")
    @ResponseBody
    public Department showDepartmentFromEmployee(@PathVariable("myid")String departmentId) {
        Department department = departmentService.selectByPrimaryKey(departmentId);
        return department;
    }

    //增加员工，返回null的json数据
    @RequestMapping("employee/add_judge")
    @ResponseBody
    public String returnToAddEmployee() {
        return null;
    }

    //增加员工，返回增加员工页面的jsp
    @RequestMapping("employee/add")
    public String goToAddEmployeePage() {
        return "employee_add";
    }

    //增加员工的部门回显
    @RequestMapping("department/get_data")
    @ResponseBody
    public List<Department> showAllDepartment() {
        List<Department> departments = departmentService.showAllDepartment();
        return departments;
    }

    //增加员工的提交处理，返回json的增加结果(ResultVo)
    @RequestMapping("employee/insert")
    @ResponseBody
    public ResponseVo insertEmployee(Employee employee) {
        int insert = employeeService.insertSelective(employee);
        if (insert == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }
    }

    /*------------------------编辑员工--------------------------*/

    //编辑员工，返回null的json数据
    @RequestMapping("employee/edit_judge")
    @ResponseBody
    public String returnToEditEmployee() {
        return null;
    }

    //增加员工，返回增加员工页面的jsp
    @RequestMapping("employee/edit")
    public String goToEditEmployeePage() {
        return "employee_edit";
    }

    //修改员工，返回修改状态码
    @RequestMapping("employee/update_all")
    @ResponseBody
    public ResponseVo updateEmployee(Employee employee) {
        int update = employeeService.updateByPrimaryKeySelective(employee);
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

    /*------------------------删除员工------------------------*/
    //返回null的json
    @RequestMapping("employee/delete_judge")
    @ResponseBody
    public String deleteEmployee() {
        return null;
    }

    //执行删除并返回删除结果的状态码
    @RequestMapping("employee/delete_batch")
    @ResponseBody
    public ResponseVo employeeDelete(String[] ids) {
        int delete = employeeService.deleteEmployeeByIds(ids);
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
