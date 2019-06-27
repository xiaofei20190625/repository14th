package com.lyn.mytest;

import com.cskaoyan.bean.Department;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.service.DepartmentService;
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
    DepartmentService departmentService;
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
}
