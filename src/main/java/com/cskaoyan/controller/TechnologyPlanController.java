package com.cskaoyan.controller;

import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:46
 */
@Controller
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("technologyPlan/find")
    public String findTechnologyPlan(){
        return "technologyPlan_list";
    }
    @RequestMapping("technologyPlan/list")
    @ResponseBody
    public Vo<TechnologyPlan> returnTechnologyPlan(int page, int rows){
        Vo<TechnologyPlan> technologyPlanVo = technologyPlanService.findTechnologyPlan(page, rows);
        return technologyPlanVo;
    }
    @RequestMapping("technologyPlan/get/{planid}")
    @ResponseBody
    public TechnologyPlan getTechnologyPlan(@PathVariable("planid")int planid){
        return technologyPlanService.getTechnologyPlan(planid);
    }
}
