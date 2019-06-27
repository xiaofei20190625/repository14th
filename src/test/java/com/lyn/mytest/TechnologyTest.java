package com.lyn.mytest;

import com.alibaba.druid.pool.DruidDataSource;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.TechnologyService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 21:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TechnologyTest {
    @Autowired
    TechnologyService technologyService;

    @Test
    public void test1(){
        List<Technology> allTechnologies = technologyService.findAllTechnology();
        System.out.println(allTechnologies);
    }

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void init(){
        Resources.getResourceAsStream("")
    }


    @Test
    public void insert1(){

    }

}
