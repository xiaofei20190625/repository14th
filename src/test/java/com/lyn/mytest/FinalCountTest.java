package com.lyn.mytest;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.mapper.FinalCountCheckMapper;
import com.cskaoyan.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan.service.FinalCountService;
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
public class FinalCountTest {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Autowired
    FinalCountService finalCountService;

    @Test
    public void mytest1() {
        Vo<FinalCountCheck> finalCountCheckVo = finalCountService.queryAllFinalCountCheck(1, 5);
        System.out.println(finalCountCheckVo);
    }
}
