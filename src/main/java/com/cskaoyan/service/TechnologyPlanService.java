package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.vo.Vo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:55
 */
public interface TechnologyPlanService {

    Vo<TechnologyPlan> findTechnologyPlan(int page, int rows);
    TechnologyPlan getTechnologyPlan(int planid);
    int insertTechnologyPlan(TechnologyPlan technologyPlan);

    int updateTechnologyPlan(TechnologyPlan technologyPlan);

    int deleteTechnologyPlanList(String[] ids);

    Vo<TechnologyPlan> searchTechnologyPlanByTechnologyPlanId(String searchValue, int page, int rows);

    Vo<TechnologyPlan> searchTechnologyPlanByTechnologyName(String searchValue, int page, int rows);

    List<TechnologyPlan> findAllTechnologyPlan();
}
