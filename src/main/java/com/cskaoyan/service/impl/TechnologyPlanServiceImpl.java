package com.cskaoyan.service.impl;

import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:56
 */
@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public Vo<TechnologyPlan> findTechnologyPlan(int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);
        //查询technologyRequirement
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findTechnologyPlan();
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlans);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyPlanVo;
    }
    @Override
    public TechnologyPlan getTechnologyPlan(int planid) {
        return technologyPlanMapper.getTechnologyPlan(planid);
    }
}
