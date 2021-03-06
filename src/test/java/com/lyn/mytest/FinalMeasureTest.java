package com.lyn.mytest;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan.service.FinalMeasureService;
import com.cskaoyan.vo.Vo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-spring.xml")
public class FinalMeasureTest {
    @Autowired
    FinalMeasureService finalMeasureService;
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Autowired
    COrderMapper cOrderMapper;

    @Test
    public void mytest1() {
        Vo<FinalMeasuretCheck> finalMeasuretCheckVo = finalMeasureService.queryAllFinalMeasuretCheck(1, 5);
        System.out.println(finalMeasuretCheckVo);
    }

    @Test
    public void mytest2() {
        int delete = finalMeasureService.deleteByIds(new String[]{"19519"});
        System.out.println(delete);
    }
    @Test
    public void mytest3() {
        List<COrder> cOrders = cOrderMapper.selectCOrderlist();
        System.out.println(cOrders);
    }
}
