package com.lyn.mytest;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.service.COrderService;
import com.cskaoyan.utils.MD5Utils;
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

    @Test
    public void testMD5(){
        String password = "123456";
        String md5 = MD5Utils.getMD5(password);
        System.out.println(md5);
    }

    @Test
    public void testFileMD5(){
//        String filePath = "src/main/webapp/WEB-INF/jsp/custom_add.jsp";//OK
        String filePath = "F:\\JavaProjects\\ERP\\repository14th\\src\\main\\webapp\\WEB-INF\\jsp\\custom_add.jsp";
        String fileMD5 = MD5Utils.getFileMD5(filePath);
        System.out.println(fileMD5);

    }
}
