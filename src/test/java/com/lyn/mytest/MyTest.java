package com.lyn.mytest;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.service.COrderService;
import com.cskaoyan.vo.Vo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-spring.xml")
public class MyTest {
    @Autowired
    COrderService cOrderService;
    @Test
    public void test(){
    Vo<COrder> cOrderVo = new Vo<>();
    Long aLong = cOrderService.countCOrder();
    List<COrder> cOrders = cOrderService.selectCOrderlist();

    cOrderVo.setTotal(aLong);
    cOrderVo.setRows(cOrders);

    }
}
