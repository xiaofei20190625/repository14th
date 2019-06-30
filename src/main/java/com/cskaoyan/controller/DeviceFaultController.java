package com.cskaoyan.controller;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.service.DeviceFaultService;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/6/29 15:03
 * @Description TODO
 */
@Controller
@RequestMapping("deviceFault")
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    //回显
    @RequestMapping("get_data")
    @ResponseBody
    public List<DeviceFault> getData(){
        List<DeviceFault> deviceFaultList = deviceFaultService.getData();
        return  deviceFaultList;
    }

    //刷新
    @RequestMapping("list")
    @ResponseBody
    public  Vo list(Integer page , Integer rows ,DeviceFault deviceFault){
        Vo list = deviceFaultService.getList(page, rows, deviceFault);
        return  list;
    }

    //
    @RequestMapping("edit_judge")
    @ResponseBody
    public  void  editJudge(){}






}
