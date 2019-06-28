package com.cskaoyan.controller;

import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:45
 */
@Controller
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService technologyRequirementService;

    //获取工艺要求列表
    @RequestMapping("technologyRequirement/find")
    public String findTechnologyRequirement(){
        return "technologyRequirement_list";
    }
    @RequestMapping("technologyRequirement/list")
    @ResponseBody
    public Vo<TechnologyRequirement> returnTechnologyRequirement(int page, int rows){
        Vo<TechnologyRequirement> technologyRequirementVo = technologyRequirementService.findTechnologyRequirement(page, rows);
        return technologyRequirementVo;
    }
    @RequestMapping("technologyRequirement/get_data")
    @ResponseBody
    public List<TechnologyRequirement> getTechnologyRequirement(){
        List<TechnologyRequirement> technologyRequirementList = technologyRequirementService.findAllTechnologyRequirement();
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
        int insert = technologyRequirementService.insertTechnologyRequirement(technologyRequirement);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    //编辑工艺要求-跳转
    @RequestMapping("technologyRequirement/edit_judge")
    @ResponseBody
    public String technologyRequirementEditJudge(){
        return "";
    }
    @RequestMapping("technologyRequirement/edit")
    public String technologyRequirementEdit(){
        return "technologyRequirement_edit";
    }
    //编辑工艺要求-处理表单
    @RequestMapping("technologyRequirement/update_all")
    @ResponseBody
    public ResponseVo technologyRequirementUpdateAll(TechnologyRequirement technologyRequirement){
        ResponseVo responseVo = new ResponseVo();
        int update = technologyRequirementService.updateTechnologyRequirement(technologyRequirement);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    @RequestMapping("technologyRequirement/update_requirement")
    @ResponseBody
    public ResponseVo technologyRequirementUpdate(TechnologyRequirement technologyRequirement){
        ResponseVo responseVo = new ResponseVo();
        int update = technologyRequirementService.updateTechnologyRequirement(technologyRequirement);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    //删除工艺要求-判断
    @RequestMapping("technologyRequirement/delete_judge")
    @ResponseBody
    public String technologyRequirementDeleteJudge(){
        return "";
    }
    //删除工艺要求-删除
    @RequestMapping("technologyRequirement/delete_batch")
    @ResponseBody
    public ResponseVo technologyRequirementDelete(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = technologyRequirementService.deleteTechnologyRequirementList(ids);
        if (delete > 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    //按工艺要求编号搜索
    @RequestMapping("technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public Vo<TechnologyRequirement> technologyRequirementSearchById(String searchValue, int page, int rows){
        Vo<TechnologyRequirement> technologyRequirementVo = technologyRequirementService.searchTechnologyRequirementById(searchValue, page, rows);
        return technologyRequirementVo;
    }
    //按工艺名称搜索
    @RequestMapping("technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public Vo<TechnologyRequirement> technologyRequirementSearchByName(String searchValue, int page, int rows){
        Vo<TechnologyRequirement> technologyRequirementVo = technologyRequirementService.searchTechnologyRequirementByTechnologyName(searchValue, page, rows);
        return technologyRequirementVo;
    }
}
