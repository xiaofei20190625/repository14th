package com.cskaoyan.controller;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    //新增工艺-页面跳转
    @RequestMapping("process/add_judge")
    @ResponseBody
    public String processInsertJudge(){
        return "";
    }
    @RequestMapping("process/add")
    public String processAdd(){
        return "process_add";
    }
    //新增工艺-处理表单，并进行数据库操作
    @RequestMapping("process/insert")
    @ResponseBody
    public ResponseVo processInsert(Process process){
        ResponseVo responseVo = new ResponseVo();
        int insert = processService.insertProcess(process);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //编辑工艺-跳转
    @RequestMapping("process/edit_judge")
    @ResponseBody
    public String processEditJudge(){
        return "";
    }
    @RequestMapping("process/edit")
    public String processEdit(){
        return "process_edit";
    }
    //编辑工艺-处理表单
    @RequestMapping("process/update_all")
    @ResponseBody
    public ResponseVo processUpdate(Process process){
        ResponseVo responseVo = new ResponseVo();
        int update = processService.updateProcess(process);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //删除工艺-判断
    @RequestMapping("process/delete_judge")
    @ResponseBody
    public String processDeleteJudge(){
        return "";
    }
    //删除工艺-删除
    @RequestMapping("process/delete_batch")
    @ResponseBody
    public ResponseVo processDelete(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = processService.deleteProcessList(ids);
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    //按工艺编号搜索
    @RequestMapping("process/search_process_by_processId")
    @ResponseBody
    public Vo<Process> processSearchByProcessId(String searchValue, int page, int rows){
        Vo<Process> processVo = processService.searchProcessByProcessId(searchValue, page, rows);
        return processVo;
    }

    //按工艺名称搜索
    @RequestMapping("process/search_process_by_technologyPlanId")
    @ResponseBody
    public Vo<Process> processSearchByTechnologyPlanId(String searchValue, int page, int rows){
        Vo<Process> processVo = processService.searchProcessByTechnologyPlanId(searchValue, page, rows);
        return processVo;
    }

}
