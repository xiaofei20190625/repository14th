package com.lyn.mytest;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.vo.Vo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-spring.xml")
public class PersonTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Test
    public void mytest1() {
        List<Department> departments = departmentMapper.selectAllDepartment();
        System.out.println(departments);
    }
    @Test
    public void mytest2() {
        Vo<Department> departments = departmentService.fuzzySelectByname("人", 1, 10);
        System.out.println(departments);
    }

    @Test
    public void mytest3() {
        int delete = departmentService.deleteByIds(new String[]{"015", "016"});
        System.out.println(delete);
    }

    @Test
    public void mytest4() {
        Vo<EmployeeResponse> employeeResponseVo = employeeService.queryAllEmployee(1, 10);
        System.out.println(employeeResponseVo);
    }

    @Test
    public void mytest5() {
        List<Department> departments = departmentService.showAllDepartment();
        System.out.println(departments);
    }

    @Test
    public void mytest6() {
        int delete = employeeService.deleteEmployeeByIds(new String[]{"006", "007"});
        System.out.println(delete);
    }

    @Test
    public void mytest7() {
        Vo<EmployeeResponse> employeeResponseVo = employeeService.fuzzyQueryByEmployeeId("%" + "1" + "%", 1, 5);
        System.out.println(employeeResponseVo);
    }

    @Test
    public void mytest8() {
        Vo<EmployeeResponse> employeeResponseVo = employeeService.fuzzyQueryByEmployeeName("%" + "刘" + "%", 1, 5);
        System.out.println(employeeResponseVo);
    }

    @Test
    public void mytest9() {
        Vo<EmployeeResponse> employeeResponseVo = employeeService.fuzzyQueryByDepartmentName("%" + "人" + "%", 1, 5);
        System.out.println(employeeResponseVo);
    }


}
