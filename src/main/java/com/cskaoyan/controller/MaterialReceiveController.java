package com.cskaoyan.controller;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.service.MaterialReceiveService;
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
 * Date 2019/6/28 Time 16:06
 */
@Controller
public class MaterialReceiveController {
    @Autowired
    MaterialReceiveService materialReceiveService;

    //获取物料列表
    @RequestMapping("materialReceive/find")
    public String findMaterialReceive(){
        return "materialReceive_list";
    }
    @RequestMapping("materialReceive/list")
    @ResponseBody
    public Vo<MaterialReceive> returnMaterialReceive(int page, int rows){
        Vo<MaterialReceive> materialReceiveVo = materialReceiveService.findMaterialReceive(page, rows);
        return materialReceiveVo;
    }

    //查找指定物料
    @RequestMapping("materialReceive/get/{mid}")
    @ResponseBody
    public MaterialReceive getMaterialReceive(@PathVariable("mid")int mid){
        return materialReceiveService.getMaterialReceive(mid);
    }

    //新增物料-页面跳转
    @RequestMapping("materialReceive/add_judge")
    @ResponseBody
    public String materialReceiveInsertJudge(){
        return "";
    }
    @RequestMapping("materialReceive/add")
    public String materialReceiveAdd(){
        return "materialReceive_add";
    }
    //新增物料-处理表单，并进行数据库操作
    @RequestMapping("materialReceive/insert")
    @ResponseBody
    public ResponseVo materialReceiveInsert(MaterialReceive materialReceive){
        ResponseVo responseVo = new ResponseVo();
        int insert = materialReceiveService.insertMaterialReceive(materialReceive);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //编辑物料-跳转
    @RequestMapping("materialReceive/edit_judge")
    @ResponseBody
    public String materialReceiveEditJudge(){
        return "";
    }
    @RequestMapping("materialReceive/edit")
    public String materialReceiveEdit(){
        return "materialReceive_edit";
    }
    //编辑物料-处理表单
    @RequestMapping("materialReceive/update_all")
    @ResponseBody
    public ResponseVo materialReceiveUpdateAll(MaterialReceive materialReceive){
        ResponseVo responseVo = new ResponseVo();
        int update = materialReceiveService.updateMaterialReceive(materialReceive);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    @RequestMapping("materialReceive/update_note")
    @ResponseBody
    public ResponseVo materialReceiveUpdateNote(MaterialReceive materialReceive){
        ResponseVo responseVo = new ResponseVo();
        int update = materialReceiveService.updateMaterialReceive(materialReceive);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //删除物料-判断
    @RequestMapping("materialReceive/delete_judge")
    @ResponseBody
    public String materialReceiveDeleteJudge(){
        return "";
    }
    //删除物料-删除
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public ResponseVo materialReceiveDelete(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = materialReceiveService.deleteMaterialReceiveList(ids);
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //按物料编号搜索
    @RequestMapping("materialReceive/search_materialReceive_by_receiveId")
    @ResponseBody
    public Vo<MaterialReceive> searchMaterialReceiveByReceiveId(String searchValue, int page, int rows){
        Vo<MaterialReceive> materialReceiveVo = materialReceiveService.searchMaterialReceiveByReceiveId(searchValue, page, rows);
        return materialReceiveVo;
    }

    //按物料名称搜索
    @RequestMapping("materialReceive/search_materialReceive_by_materialId")
    @ResponseBody
    public Vo<MaterialReceive> searchMaterialReceiveByMaterialId(String searchValue, int page, int rows){
        Vo<MaterialReceive> materialReceiveVo = materialReceiveService.searchMaterialReceiveByMaterialId(searchValue, page, rows);
        return materialReceiveVo;
    }

    @RequestMapping("materialReceive/get_data")
    @ResponseBody
    public List<MaterialReceive> getMaterialReceiveRequirement(){
        List<MaterialReceive> materialReceiveList = materialReceiveService.findAllMaterialReceive();
        return materialReceiveList;
    }

}
