package com.hao;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;
import com.cskaoyan.controller.COrderList;
import com.cskaoyan.service.COrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

public class Mytest {

    @Autowired
    COrderService cOrderService;
    @Autowired
    DataSource dataSource;

    COrderExample cOrderExample = new COrderExample();
    COrderExample.Criteria criteria =cOrderExample.createCriteria();


   @Test
    public void cOrderList() {
        COrderList cOrderList = new COrderList();
        criteria.andOrderIdIsNotNull();
        cOrderList.setRows(cOrderService.selectByExample(cOrderExample));
        cOrderList.setTotal(Math.toIntExact(cOrderService.countByExample(cOrderExample)));
       System.out.println(cOrderList);
    }
}
