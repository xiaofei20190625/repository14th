package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 20:52
 */

@Controller
public class HomeController {
    @RequestMapping("home")
    public String goToHome() {
        return "home";
    }

}
