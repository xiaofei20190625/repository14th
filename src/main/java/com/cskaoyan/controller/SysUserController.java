package com.cskaoyan.controller;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("query/{id}")
    @ResponseBody
    public SysUser selectByPrimaryKey(@PathVariable("id") String id){

        SysUser sysUser = sysUserService.selectByPrimaryKey(id);
        return sysUser;

    }

}
