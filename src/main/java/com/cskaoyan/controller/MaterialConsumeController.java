package com.cskaoyan.controller;

import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.service.MaterialConsumeService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 16:07
 */
@Controller
public class MaterialConsumeController {
    @Autowired
    MaterialConsumeService materialConsumeService;

    //获取物料消耗列表
    @RequestMapping("materialConsume/find")
    public String findMaterialConsume(){
        return "materialConsume_list";
    }
    @RequestMapping("materialConsume/list")
    @ResponseBody
    public Vo<MaterialConsume> returnMaterialConsume(int page, int rows){
        Vo<MaterialConsume> materialConsumeVo = materialConsumeService.findMaterialConsume(page, rows);
        return materialConsumeVo;
    }

    //查找指定物料消耗
    @RequestMapping("materialConsume/get/{tid}")
    @ResponseBody
    public MaterialConsume getMaterialConsume(@PathVariable("mcid")int mcid){
        return materialConsumeService.getMaterialConsume(mcid);
    }

    //新增物料消耗-页面跳转
    @RequestMapping("materialConsume/add_judge")
    @ResponseBody
    public String materialConsumeInsertJudge(){
        return "";
    }
    @RequestMapping("materialConsume/add")
    public String materialConsumeAdd(){
        return "materialConsume_add";
    }
    //新增物料消耗-处理表单，并进行数据库操作
    @RequestMapping("materialConsume/insert")
    @ResponseBody
    public ResponseVo materialConsumeInsert(MaterialConsume materialConsume){
        ResponseVo responseVo = new ResponseVo();
        int insert = materialConsumeService.insertMaterialConsume(materialConsume);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //编辑物料消耗-跳转
    @RequestMapping("materialConsume/edit_judge")
    @ResponseBody
    public String materialConsumeEditJudge(){
        return "";
    }
    @RequestMapping("materialConsume/edit")
    public String materialConsumeEdit(){
        return "materialConsume_edit";
    }
    //编辑物料消耗-处理表单
    @RequestMapping("materialConsume/update_all")
    @ResponseBody
    public ResponseVo materialConsumeUpdate(MaterialConsume materialConsume){
        ResponseVo responseVo = new ResponseVo();
        int update = materialConsumeService.updateMaterialConsume(materialConsume);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //删除物料消耗-判断
    @RequestMapping("materialConsume/delete_judge")
    @ResponseBody
    public String materialConsumeDeleteJudge(){
        return "";
    }
    //删除物料消耗-删除
    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public ResponseVo materialConsumeDelete(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = materialConsumeService.deleteMaterialConsumeList(ids);
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //按物料消耗编号搜索
    @RequestMapping("materialConsume/search_materialConsume_by_consumeId")
    @ResponseBody
    public Vo<MaterialConsume> materialConsumeSearchByConsumeId(String searchValue, int page, int rows){
        Vo<MaterialConsume> materialConsumeVo = materialConsumeService.materialConsumeSearchByConsumeId(searchValue, page, rows);
        return materialConsumeVo;
    }

    //按作业编号搜索
    @RequestMapping("materialConsume/search_materialConsume_by_workId")
    @ResponseBody
    public Vo<MaterialConsume> materialConsumeSearchByWorkId(String searchValue, int page, int rows){
        Vo<MaterialConsume> materialConsumeVo = materialConsumeService.materialConsumeSearchByWorkId(searchValue, page, rows);
        return materialConsumeVo;
    }

    //按物料编号搜索
    @RequestMapping("materialConsume/search_materialConsume_by_materialId")
    @ResponseBody
    public Vo<MaterialConsume> materialConsumeSearchByMaterialId(String searchValue, int page, int rows){
        Vo<MaterialConsume> materialConsumeVo = materialConsumeService.materialConsumeSearchByMaterialId(searchValue, page, rows);
        return materialConsumeVo;
    }

    @RequestMapping("materialConsume/get_data")
    @ResponseBody
    public List<MaterialConsume> getMaterialConsumeRequirement(){
        List<MaterialConsume> materialConsumeList = materialConsumeService.findAllMaterialConsume();
        return materialConsumeList;
    }
}
