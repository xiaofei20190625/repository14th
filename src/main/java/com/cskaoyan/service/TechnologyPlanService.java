package com.cskaoyan.service;

import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.vo.Vo;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:55
 */
public interface TechnologyPlanService {

    Vo<TechnologyPlan> findTechnologyPlan(int page, int rows);
    TechnologyPlan getTechnologyPlan(int planid);
}
