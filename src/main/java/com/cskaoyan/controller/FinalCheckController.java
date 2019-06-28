package com.cskaoyan.controller;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.service.FinalMeasureService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FinalCheckController {
    @Autowired
    FinalMeasureService finalMeasureService;

    /*------------------成品计量查询-------------------*/
    //返回jsp:measurement_list
    @RequestMapping("measure/find")
    public String goToMesure1Page() {
        return "measurement_list";
    }
    //http://192.168.2.100:8080/erp/measure/list?page=1&rows=10
    //返回成品计量数据
    @RequestMapping("measure/list")
    @ResponseBody
    public Vo<FinalMeasuretCheck> returnFinalMeasure(int page, int rows) {
        Vo<FinalMeasuretCheck> FinalMeasuretCheckVo = finalMeasureService.queryAllFinalMeasuretCheck(page, rows);
        return FinalMeasuretCheckVo;
    }

    /*--------------成品计量新增----------------*/
    //http://192.168.2.100:8080/erp/fMeasureCheck/add_judge--json null
    //返回json-null
    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public String goToAddFinalMeasure() {
        return null;
    }
    //http://192.168.2.100:8080/erp/measure/add?_=1561727366339 返回jsp页面
    @RequestMapping("measure/add")
    public String addFinalMeasure() {
        return "measurement_add";
    }


    /*------------编辑不合格项---------------*/
    //返回json-null
    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public String goToEditFinalMeasure() {
        return null;
    }
    //返回编辑FinalMeasure的jsp页面
    @RequestMapping("measure/edit")
    public String editFinalMeasure() {
        return "measurement_edit";
    }

    //修改不合格项
    /*Request URL: http://192.168.2.100:8080/erp/unqualify/update_all
     */
    @RequestMapping("measure/update_all")
    @ResponseBody
    public ResponseVo updateFinalMeasure(FinalMeasuretCheck record) {
        int update = finalMeasureService.updateByPrimaryKeySelective(record);
        if (update == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        }
        return null;
    }



    /*-------------删除-------------*/
    //删除不合格项,执行删除并返回删除结果的状态码
    //http://192.168.2.100:8080/erp/fMeasureCheck/delete_judge
    //http://192.168.2.100:8080/erp/measure/delete_batch
    @RequestMapping("measure/delete_batch")
    @ResponseBody
    public ResponseVo measureDelete(String[] ids) {
        int delete = finalMeasureService.deleteByIds(ids);
        if (delete > 0) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }
    }

    //返回json-null
    @RequestMapping("fMeasureCheck/delete_judge")
    @ResponseBody
    public String goToDeleteUnqualifyApply() {
        return null;
    }



}
