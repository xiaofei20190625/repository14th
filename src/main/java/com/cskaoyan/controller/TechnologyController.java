package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("technology/find")
    public String findTechnology(){
        return "technology_list";
    }

    @RequestMapping("technology/list")
    @ResponseBody
    public List<Technology> returnTechnology(int page, int rows){
        List<Technology> technologies = technologyService.findPageTechnology(page, rows);
        return technologies;
    }

    @RequestMapping("technologyRequirement/find")
    public String findTechnologyRequirement(){
        return "technologyRequirement_list";
    }

    @RequestMapping("technologyRequirement/list")
    public List<TechnologyRequirement> returnTechnologyRequirement(){
        List<TechnologyRequirement> technologyRequirements = technologyService.findAllTechnologyRequirement();
        return technologyRequirements;
    }

}
