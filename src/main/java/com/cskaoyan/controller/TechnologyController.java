package com.cskaoyan.controller;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 17:36
 */
@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    //-------------工艺管理-------------
    //获取工艺列表
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
    //查找指定工艺
    @RequestMapping("technology/get/{tid}")
    @ResponseBody
    public Technology getTechnology(@PathVariable("tid")int tid){
        return technologyService.getTechnology(tid);
    }

    //新增工艺-页面跳转
    @RequestMapping("technology/add_judge")
    @ResponseBody
    public String technologyInsertJudge(){
        return "";
    }
    @RequestMapping("technology/add")
    public String technologyAdd(){
        return "technology_add";
    }
    //新增工艺-处理表单，并进行数据库操作
    @RequestMapping("technology/insert")
    @ResponseBody
    public ResponseVo technologyInsert(Technology technology){
        ResponseVo responseVo = new ResponseVo();
        int insert = technologyService.insertTechnology(technology);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    //编辑工艺-跳转
    @RequestMapping("technology/edit_judge")
    @ResponseBody
    public String technologyEditJudge(){
        return "";
    }
    @RequestMapping("technology/edit")
    public String technologyEdit(){
        return "technology_edit";
    }
    //编辑工艺-处理表单
    @RequestMapping("technology/update_all")
    @ResponseBody
    public ResponseVo technologyUpdate(Technology technology){
        ResponseVo responseVo = new ResponseVo();
        int update = technologyService.updateTechnology(technology);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    //删除工艺-判断
    @RequestMapping("technology/delete_judge")
    @ResponseBody
    public String technologyDeleteJudge(){
        return "";
    }
    //删除工艺-删除
    @RequestMapping("technology/delete_batch")
    @ResponseBody
    public ResponseVo technologyDelete(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = technologyService.deleteTechnologyList(ids);
        if (delete > 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    //按工艺编号搜索
    @RequestMapping("technology/search_technology_by_technologyId")
    @ResponseBody
    public Vo<Technology> technologySearchById(String searchValue, int page, int rows, Model model){
        Vo<Technology> technologyVo = technologyService.searchTechnologyById(searchValue, page, rows);
        return technologyVo;
    }

    //按工艺名称搜索
    @RequestMapping("technology/search_technology_by_technologyName")
    @ResponseBody
    public Vo<Technology> technologySearchByName(String searchValue, int page, int rows, Model model){
        Vo<Technology> technologyVo = technologyService.searchTechnologyByName(searchValue, page, rows);
        return technologyVo;
    }

    //-------------工艺要求-------------
    //获取工艺要求列表
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
    @RequestMapping("technologyRequirement/get_data")
    @ResponseBody
    public List<TechnologyRequirement> getTechnologyRequirement(){
        List<TechnologyRequirement> technologyRequirementList = technologyService.findAllTechnologyRequirement();
        return technologyRequirementList;
    }
    //新增工艺要求-页面跳转
    @RequestMapping("technologyRequirement/add_judge")
    @ResponseBody
    public String technologyRequirementInsertJudge(){
        return "";
    }
    @RequestMapping("technologyRequirement/add")
    public String technologyRequirementAdd(){
        return "technologyRequirement_add";
    }
    //新增工艺要求-处理表单，并进行数据库操作
    @RequestMapping("technologyRequirement/insert")
    @ResponseBody
    public ResponseVo technologyRequirementInsert(TechnologyRequirement technologyRequirement){
        ResponseVo responseVo = new ResponseVo();
        int insert = technologyService.insertTechnologyRequirement(technologyRequirement);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }




    //-------------工艺计划-------------
    //获取工艺计划列表
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
    @RequestMapping("technologyPlan/get/{planid}")
    @ResponseBody
    public TechnologyPlan getTechnologyPlan(@PathVariable("planid")int planid){
        return technologyService.getTechnologyPlan(planid);
    }

    //-------------工序管理-------------
    //获取工序列表
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
