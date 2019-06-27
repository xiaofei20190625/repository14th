package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
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

    @RequestMapping("technology/get/{tid}")
    @ResponseBody
    public Technology getTechnology(@PathVariable("tid")int tid){
        return technologyService.getTechnology(tid);
    }

}
