package com.cskaoyan.controller;

import com.cskaoyan.bean.EmployeeResponse;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.service.ProductService;
import com.cskaoyan.service.UnqualifyApplyService;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UnqualifyController {
    @Autowired
    UnqualifyApplyService unqualifyApplyService;
    @Autowired
    ProductService productService;
    @Autowired
    EmployeeService employeeService;
    /*---------------------查询所有不合格项--------------------------*/
    @RequestMapping("unqualify/find")
    public String goTounqualifyListPage() {
        return "unqualify_list";
    }

    //返回不合格项的json数据
    @RequestMapping("unqualify/list")
    @ResponseBody
    public Vo<UnqualifyApply> returnUnqualify(int page, int rows) {
        Vo<UnqualifyApply> unqualifyApplyVo = unqualifyApplyService.queryAllUnqualifyApply(page, rows);
        return unqualifyApplyVo;
    }

    //产品回显
    @RequestMapping("product/get/{pid}")
    @ResponseBody
    public Product showProduct(@PathVariable("pid") String pid) {
        Product product = productService.selectByPrimaryKey(pid);
        return product;
    }
    //不合格品申请人的回显
    /*http://localhost/employee/get/001*/
    @RequestMapping("employee/get/{empId}")
    @ResponseBody
    public EmployeeResponse showEmployeeResponse(@PathVariable("empId") String empId) {
        return employeeService.selectByPrimaryKey(empId);
    }



}
