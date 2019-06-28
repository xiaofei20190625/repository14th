package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.service.MaterialService;
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
public class MaterialController {
    @Autowired
    MaterialService materialService;

    //获取物料列表
    @RequestMapping("material/find")
    public String findMaterial(){
        return "material_list";
    }
    @RequestMapping("material/list")
    @ResponseBody
    public Vo<Material> returnMaterial(int page, int rows){
        Vo<Material> materialVo = materialService.findMaterial(page, rows);
        return materialVo;
    }

    //查找指定物料
    @RequestMapping("material/get/{mid}")
    @ResponseBody
    public Material getMaterial(@PathVariable("mid")String mid){
        return materialService.getMaterial(mid);
    }

    //新增物料-页面跳转
    @RequestMapping("material/add_judge")
    @ResponseBody
    public String materialInsertJudge(){
        return "";
    }
    @RequestMapping("material/add")
    public String materialAdd(){
        return "material_add";
    }
    //新增物料-处理表单，并进行数据库操作
    @RequestMapping("material/insert")
    @ResponseBody
    public ResponseVo materialInsert(Material material){
        ResponseVo responseVo = new ResponseVo();
        int insert = materialService.insertMaterial(material);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //编辑物料-跳转
    @RequestMapping("material/edit_judge")
    @ResponseBody
    public String materialEditJudge(){
        return "";
    }
    @RequestMapping("material/edit")
    public String materialEdit(){
        return "material_edit";
    }
    //编辑物料-处理表单
    @RequestMapping("material/update_all")
    @ResponseBody
    public ResponseVo materialUpdateAll(Material material){
        ResponseVo responseVo = new ResponseVo();
        int update = materialService.updateMaterial(material);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }
    @RequestMapping("material/update_note")
    @ResponseBody
    public ResponseVo materialUpdateNote(Material material){
        ResponseVo responseVo = new ResponseVo();
        int update = materialService.updateMaterial(material);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //删除物料-判断
    @RequestMapping("material/delete_judge")
    @ResponseBody
    public String materialDeleteJudge(){
        return "";
    }
    //删除物料-删除
    @RequestMapping("material/delete_batch")
    @ResponseBody
    public ResponseVo materialDelete(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = materialService.deleteMaterialList(ids);
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //按物料编号搜索
    @RequestMapping("material/search_material_by_materialId")
    @ResponseBody
    public Vo<Material> searchMaterialByMaterialId(String searchValue, int page, int rows){
        Vo<Material> materialVo = materialService.searchMaterialByMaterialId(searchValue, page, rows);
        return materialVo;
    }

    //按物料名称搜索
    @RequestMapping("material/search_material_by_materialType")
    @ResponseBody
    public Vo<Material> searchMaterialByMaterialType(String searchValue, int page, int rows){
        Vo<Material> materialVo = materialService.searchMaterialByMaterialType(searchValue, page, rows);
        return materialVo;
    }

    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material> getMaterialRequirement(){
        List<Material> materialList = materialService.findAllMaterial();
        return materialList;
    }


}
