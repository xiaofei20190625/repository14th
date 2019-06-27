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
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "home";
    }

}
