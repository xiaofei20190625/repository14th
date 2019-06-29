package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 20:52
 */

@Controller
public class HomeController {
    @RequestMapping("home")
    public String goToHome(HttpSession session) {
        List<String> sysPermissionList = new ArrayList<>();
        //部门
        sysPermissionList.add("department:add");
        sysPermissionList.add("department:edit");
        sysPermissionList.add("department:delete");

        /**
         * 计划进度
         */
        //订单管理
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        //客户管理
        sysPermissionList.add("custom:add");
        sysPermissionList.add("custom:edit");
        sysPermissionList.add("custom:delete");
        //产品管理
        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        //作业管理
        sysPermissionList.add("work:add");
        sysPermissionList.add("work:edit");
        sysPermissionList.add("work:delete");
        //生产计划管理
        sysPermissionList.add("manufacture:add");
        sysPermissionList.add("manufacture:edit");
        sysPermissionList.add("manufacture:delete");
        //生产派工管理
        sysPermissionList.add("task:add");
        sysPermissionList.add("task:edit");
        sysPermissionList.add("task:delete");
        /**
         * 工艺
         */

        //质量监控
        sysPermissionList.add("unqualify:add");
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");

        //成品计量质检
        sysPermissionList.add("fMeasureCheck:add");
        sysPermissionList.add("fMeasureCheck:edit");
        sysPermissionList.add("fMeasureCheck:delete");




        //工艺模块：
        sysPermissionList.add("technology:add");
        sysPermissionList.add("technology:edit");
        sysPermissionList.add("technology:delete");
        //工艺计划模块
        sysPermissionList.add("technologyPlan:add");
        sysPermissionList.add("technologyPlan:edit");
        sysPermissionList.add("technologyPlan:delete");
        //工艺要求模块
        sysPermissionList.add("technologyRequirement:add");
        sysPermissionList.add("technologyRequirement:edit");
        sysPermissionList.add("technologyRequirement:delete");
        //工序模块
        sysPermissionList.add("process:add");
        sysPermissionList.add("process:edit");
        sysPermissionList.add("process:delete");
        //物料模块
        sysPermissionList.add("material:add");
        sysPermissionList.add("material:edit");
        sysPermissionList.add("material:delete");
        //物料收入
        sysPermissionList.add("materialReceive:add");
        sysPermissionList.add("materialReceive:edit");
        sysPermissionList.add("materialReceive:delete");
        //物料消耗
        sysPermissionList.add("materialConsume:add");
        sysPermissionList.add("materialConsume:edit");
        sysPermissionList.add("materialConsume:delete");

        sysPermissionList.add("employee:add");
        sysPermissionList.add("employee:edit");
        sysPermissionList.add("employee:delete");
        /**
         * 设备
         */
        /*设备台账*/
        sysPermissionList.add("device:add");
        sysPermissionList.add("device:edit");
        sysPermissionList.add("device:delete");
        /*设备种类*/
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        /*设备例检*/
        sysPermissionList.add("deviceCheck:add");
        sysPermissionList.add("deviceCheck:edit");
        sysPermissionList.add("deviceCheck:delete");
        /*设备故障*/
        sysPermissionList.add("deviceFault:add");
        sysPermissionList.add("deviceFault:edit");
        sysPermissionList.add("deviceFault:delete");
        /*设备维修*/
        sysPermissionList.add("deviceMaintain:add");
        sysPermissionList.add("deviceMaintain:edit");
        sysPermissionList.add("deviceMaintain:delete");


        session.setAttribute("sysPermissionList", sysPermissionList);
        return "home";
    }

}
