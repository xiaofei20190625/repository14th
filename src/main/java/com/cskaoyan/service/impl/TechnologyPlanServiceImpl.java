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
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.findTechnologyPlan();
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlans);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyPlanVo;
    }
    @Override
    public TechnologyPlan getTechnologyPlan(int planid) {
        return technologyPlanMapper.getTechnologyPlan(planid);
    }
    @Override
    public int insertTechnologyPlan(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.insert(technologyPlan);
    }

    @Override
    public int updateTechnologyPlan(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.updateByPrimaryKeySelective(technologyPlan);
    }

    @Override
    public int deleteTechnologyPlanList(String[] ids) {
        return technologyPlanMapper.deleteTechnologyPlanList(ids);
    }

    @Override
    public Vo<TechnologyPlan> searchTechnologyPlanByTechnologyPlanId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.searchTechnologyPlanByTechnologyPlanId(searchValue);
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlans);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyPlanVo;
    }

    @Override
    public Vo<TechnologyPlan> searchTechnologyPlanByTechnologyName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanMapper.searchTechnologyPlanByTechnologyName(searchValue);
        PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(technologyPlans);
        Vo<TechnologyPlan> technologyPlanVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyPlanVo;
    }

    @Override
    public List<TechnologyPlan> findAllTechnologyPlan() {
        return technologyPlanMapper.findTechnologyPlan();
    }
}
