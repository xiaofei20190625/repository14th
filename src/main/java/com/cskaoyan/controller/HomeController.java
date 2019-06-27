package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("home")
    public String goToHome(/*HttpSession session*/) {
        /*List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("department:add");
        sysPermissionList.add("department:edit");
        sysPermissionList.add("'department:delete'");
        session.setAttribute("sysPermissionList", sysPermissionList);*/
        return "home";
    }

}
