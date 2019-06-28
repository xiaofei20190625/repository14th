package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnqualifyController {
    /*http://192.168.2.100:8080/erp/unqualify/find?_=1561706774188---返回页面*/
    /*---------------------查询所有不合格项--------------------------*/
    @RequestMapping("unqualify/find")
    public String goTounqualifyListPage() {
        return "unqualify_list";
    }
}
