package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 17:36
 */
@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

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
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //按工艺编号搜索
    @RequestMapping("technology/search_technology_by_technologyId")
    @ResponseBody
    public Vo<Technology> technologySearchById(String searchValue, int page, int rows){
        Vo<Technology> technologyVo = technologyService.searchTechnologyById(searchValue, page, rows);
        return technologyVo;
    }

    //按工艺名称搜索
    @RequestMapping("technology/search_technology_by_technologyName")
    @ResponseBody
    public Vo<Technology> technologySearchByName(String searchValue, int page, int rows){
        Vo<Technology> technologyVo = technologyService.searchTechnologyByName(searchValue, page, rows);
        return technologyVo;
    }

    @RequestMapping("technology/get_data")
    @ResponseBody
    public List<Technology> getTechnologyRequirement(){
        List<Technology> technologyList = technologyService.findAllTechnology();
        return technologyList;
    }
}
