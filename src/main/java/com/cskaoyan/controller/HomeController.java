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
        sysPermissionList.add("department:add");
        sysPermissionList.add("department:edit");
        sysPermissionList.add("department:delete");
        sysPermissionList.add("employee:add");
        sysPermissionList.add("employee:edit");
        sysPermissionList.add("employee:delete");
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
