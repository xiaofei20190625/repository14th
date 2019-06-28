package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.vo.ResponseVo;
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

    //新增工艺计划-页面跳转
    @RequestMapping("technologyPlan/add_judge")
    @ResponseBody
    public String technologyPlanInsertJudge(){
        return "";
    }
    @RequestMapping("technologyPlan/add")
    public String technologyPlanAdd(){
        return "technologyPlan_add";
    }
    //新增工艺计划-处理表单，并进行数据库操作
    @RequestMapping("technologyPlan/insert")
    @ResponseBody
    public ResponseVo technologyPlanInsert(TechnologyPlan technologyPlan){
        ResponseVo responseVo = new ResponseVo();
        int insert = technologyPlanService.insertTechnologyPlan(technologyPlan);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //编辑工艺计划-跳转
    @RequestMapping("technologyPlan/edit_judge")
    @ResponseBody
    public String technologyPlanEditJudge(){
        return "";
    }
    @RequestMapping("technologyPlan/edit")
    public String technologyPlanEdit(){
        return "technologyPlan_edit";
    }
    //编辑工艺计划-处理表单
    @RequestMapping("technologyPlan/update_all")
    @ResponseBody
    public ResponseVo technologyPlanUpdate(TechnologyPlan technologyPlan){
        ResponseVo responseVo = new ResponseVo();
        int update = technologyPlanService.updateTechnologyPlan(technologyPlan);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //删除工艺-判断
    @RequestMapping("technologyPlan/delete_judge")
    @ResponseBody
    public String technologyPlanDeleteJudge(){
        return "";
    }
    //删除工艺-删除
    @RequestMapping("technologyPlan/delete_batch")
    @ResponseBody
    public ResponseVo technologyPlanDelete(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = technologyPlanService.deleteTechnologyPlanList(ids);
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //按工艺编号搜索
    @RequestMapping("technologyPlan/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public Vo<TechnologyPlan> technologyPlanSearchById(String searchValue, int page, int rows){
        Vo<TechnologyPlan> technologyPlanVo = technologyPlanService.searchTechnologyPlanByTechnologyPlanId(searchValue, page, rows);
        return technologyPlanVo;
    }

    //按工艺名称搜索
    @RequestMapping("technologyPlan/search_technologyPlan_by_technologyName")
    @ResponseBody
    public Vo<TechnologyPlan> technologyPlanSearchByName(String searchValue, int page, int rows){
        Vo<TechnologyPlan> technologyPlanVo = technologyPlanService.searchTechnologyPlanByTechnologyName(searchValue, page, rows);
        return technologyPlanVo;
    }
}
