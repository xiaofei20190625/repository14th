package com.cskaoyan.controller;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;
import com.cskaoyan.service.COrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("erp")
public class PlanController {
    @Autowired
    COrderService cOrderService;
    @Autowired
    DataSource dataSource;

    COrderExample cOrderExample = new COrderExample();
    COrderExample.Criteria criteria =cOrderExample.createCriteria();



    @RequestMapping("order/list")
    @ResponseBody
    public COrderList cOrderList() {
        COrderList cOrderList = new COrderList();
        criteria.andOrderIdIsNotNull();

        return cOrderList;
    }
    @RequestMapping("order/find")
    public String selectByExample() {

        return "order_list";
    }


}
