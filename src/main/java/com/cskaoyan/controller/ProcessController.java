package com.cskaoyan.controller;

import com.cskaoyan.bean.Process;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:46
 */
@Controller
public class ProcessController {
    @Autowired
    ProcessService processService;

    //获取工序列表
    @RequestMapping("process/find")
    public String findProcess(){
        return "process_list";
    }
    @RequestMapping("process/list")
    @ResponseBody
    public Vo<Process> returnProcess(int page, int rows){
        Vo<Process> processVo = processService.findProcess(page, rows);
        return processVo;
    }
}
