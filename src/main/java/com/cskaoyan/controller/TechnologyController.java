package com.cskaoyan.controller;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 17:36
 */
@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    //工艺管理
    @RequestMapping("technology/find")
    public String findTechnology(){
        return "technology_list";
    }
    @RequestMapping("technology/list")
    @ResponseBody
    public Vo<Technology> returnTechnology(int page, int rows){
        Vo<Technology> technologyVo = technologyService.findTechnology(page, rows);
        return technologyVo;
    }

    //工艺要求
    @RequestMapping("technologyRequirement/find")
    public String findTechnologyRequirement(){
        return "technologyRequirement_list";
    }
    @RequestMapping("technologyRequirement/list")
    @ResponseBody
    public Vo<TechnologyRequirement> returnTechnologyRequirement(int page, int rows){
        Vo<TechnologyRequirement> technologyRequirementVo = technologyService.findTechnologyRequirement(page, rows);
        return technologyRequirementVo;
    }

    //查找指定工艺
    @RequestMapping("technology/get/{tid}")
    @ResponseBody
    public Technology getTechnology(@PathVariable("tid")int tid){
        return technologyService.getTechnology(tid);
    }

    //工艺计划
    @RequestMapping("technologyPlan/find")
    public String findTechnologyPlan(){
        return "technologyPlan_list";
    }
    @RequestMapping("technologyPlan/list")
    @ResponseBody
    public Vo<TechnologyPlan> returnTechnologyPlan(int page, int rows){
        Vo<TechnologyPlan> technologyPlanVo = technologyService.findTechnologyPlan(page, rows);
        return technologyPlanVo;
    }

    //工序管理
    @RequestMapping("process/find")
    public String findProcess(){
        return "process_list";
    }
    @RequestMapping("process/list")
    @ResponseBody
    public Vo<Process> returnProcess(int page, int rows){
        Vo<Process> processVo = technologyService.findProcess(page, rows);
        return processVo;
    }
}
