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
        sysPermissionList.add("'department:delete'");
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

        session.setAttribute("sysPermissionList", sysPermissionList);
        return "home";
    }

}
