package com.cskaoyan.controller;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.mapper.FinalCountCheckMapper;
import com.cskaoyan.service.FinalCountService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FinalCountController {
    @Autowired
    FinalCountService finalCountService;
    /*------------------成品计量查询-------------------*/
    //返回jsp:f_count_check_list
    @RequestMapping("f_count_check/find")
    public String goToCountCheckPage() {
        return "f_count_check_list";
    }
    //f_count_check/list?page=1&rows=10    //返回成品计量数据
    @RequestMapping("f_count_check/list")
    @ResponseBody
    public Vo<FinalCountCheck> returnFinalCountCheck(int page, int rows) {
        Vo<FinalCountCheck> finalCountCheckVo = finalCountService.queryAllFinalCountCheck(page, rows);
        return finalCountCheckVo;
    }

    /*--------------成品计量新增----------------*/
    //返回json-null
    @RequestMapping("fCountCheck/add_judge")
    @ResponseBody
    public String goToAddFinalCount() {
        return null;
    }
    //http://192.168.2.100:8080/erp/fCountCheck/add?_=1561727366339 返回jsp页面
    @RequestMapping("f_count_check/add")
    public String addFinalCount() {
        return "f_count_check_add";
    }


    /*----------------------新增FinalfCountCheckCheck--------------------------*/
    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public ResponseVo insertFinalfCountCheck(FinalCountCheck finalCountCheck) {
        int insert = finalCountService.insertSelective(finalCountCheck);
        if (insert == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        }
        return null;
    }


    /*------------编辑不合格项------------*/
    //返回json-null
    @RequestMapping("fCountCheck/edit_judge")
    @ResponseBody
    public String goToEditFinalfCountCheck() {
        return null;
    }
    //返回编辑FinalfCountCheck的jsp页面
    @RequestMapping("f_count_check/edit")
    public String editFinalfCountCheck() {
        return "f_count_check_edit";
    }

    //修改不合格项
    /*Request URL: http://192.168.2.100:8080/erp/unqualify/update_all
     */
    @RequestMapping("f_count_check/update_all")
    @ResponseBody
    public ResponseVo updateFinalfCountCheck(FinalCountCheck record) {
        int update = finalCountService.updateByPrimaryKeySelective(record);
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
    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public ResponseVo fCountCheckDelete(String[] ids) {
        int delete = finalCountService.deleteByIds(ids);
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
    @RequestMapping("fCountCheck/delete_judge")
    @ResponseBody
    public String goToDeleteFCountCheck() {
        return null;
    }


    /*-------------模糊查询----------------*/

    //根据成品质检编号模糊查询
    //search_fCountCheck_by_fCountCheckId?searchValue=1&page=1&rows=10
    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public Vo<FinalCountCheck> fuzzyQueryFinalfCountCheckById(String searchValue, int page, int rows) {
        Vo<FinalCountCheck> finalCountCheckVo = finalCountService.fuzzyQueryFinalCountCheckById(searchValue, page, rows);
        return finalCountCheckVo;
    }
    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public Vo<FinalCountCheck> fuzzyQueryFinalfCountByOrderId(String searchValue, int page, int rows) {
        Vo<FinalCountCheck> finalCountCheckVo = finalCountService.fuzzyQueryFinalCountCheckByOrderId(searchValue, page, rows);
        return finalCountCheckVo;
    }



}
