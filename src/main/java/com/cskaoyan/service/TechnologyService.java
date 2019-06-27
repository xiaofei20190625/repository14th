package com.cskaoyan.service;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.vo.Vo;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 17:42
 */
public interface TechnologyService {
    //工艺管理
    Vo<Technology> findTechnology(int page, int rows);

    //工艺要求
    Vo<TechnologyRequirement> findTechnologyRequirement(int page, int rows);

    //查询工艺
    Technology getTechnology(int tid);

    //工艺计划
    Vo<TechnologyPlan> findTechnologyPlan(int page, int rows);

    //工序管理
    Vo<Process> findProcess(int page, int rows);
}

