package com.lyn.mytest;

import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.mapper.UnqualifyApplyMapper;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.service.UnqualifyApplyService;
import com.cskaoyan.vo.Vo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-spring.xml")
public class UnqualifyTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    @Autowired
    UnqualifyApplyService unqualifyApplyService;
    @Autowired
    EmployeeService employeeService;
    @Test
    public void mytest1() {
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.queryAllUnqualifyApply();
        System.out.println(unqualifyApplies);

    }

    @Test
    public void mytest2() {
        EmployeeResponse employeeResponse = employeeService.selectByPrimaryKey("001");
        System.out.println(employeeResponse);
    }

    @Test
    public void mytest3() {
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.fuzzyQueryUnqualifyById("%" + "1" + "%");
        System.out.println(unqualifyApplies);
    }
    @Test
    public void mytest4() {
        //List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.fuzzyQueryUnqualifyByProductName("%" + "子" + "%");
        Vo<UnqualifyApply> unqualifyApplyVo = unqualifyApplyService.fuzzyQueryUnqualifyByProductName("子", 1, 5);
        System.out.println(unqualifyApplyVo);
    }
}
