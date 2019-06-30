package com.cskaoyan.controller;


import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.UserRole;
import com.cskaoyan.bean.SysUser;
import com.cskaoyan.service.SysUserService;
import com.cskaoyan.service.UserRoleService;
import com.cskaoyan.utils.MD5Utils;
import com.cskaoyan.vo.ActiveUser;
import com.cskaoyan.vo.Login;
import com.cskaoyan.vo.ResponseVo;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;


@Controller
public class SysUserController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    UserRoleService userRoleService;


    @RequestMapping("/")
    public String home() {
        return "login";
    }

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @param session session
     * @return 登陆信息
     */
    @RequestMapping("ajaxLogin")
    @ResponseBody
    public Login LoginSysUser(String username, String password, HttpSession session){

        Login login = sysUserService.loginSysUser(username,password);
        if (login.getMsg().equals("success")){
            HomeController homeController = new HomeController();
            ActiveUser activeUser = new ActiveUser();
            SysUser sysUser = sysUserService.selectByPrimaryKey(username);
            UserRole userRole = sysUser.getUserRole();
            String rolename = userRole.getRoleName();
            activeUser.setRolename(rolename);
            activeUser.setUsername(username);

            session.setAttribute("activeUser",activeUser);
            homeController.goToHome(session);
        }
        return login;
    }


    @RequestMapping("logout")
    public String LoginoutSysUser(HttpSession session){
        HomeController homeController = new HomeController();
        session.setAttribute("activeUser",null);
        homeController.goToHome(session);
        return "login";
    }

    @RequestMapping("user/find")
    public String userFind() {

        return "user_list";
    }
    @RequestMapping("user/list")
    @ResponseBody
    public Vo<SysUser> userList(int page , int rows) {
        Vo<SysUser> sysUserPage = sysUserService.findSysUserPage(page, rows);
        return sysUserPage;
    }

   /* erp/role/get/001
    {roleId: "001", roleName: "超级管理员", available: "1"}
    available: "1"
    roleId: "001"
    roleName: "超级管理员"

    user/role
    permission/get_permission?roleId=001
    {id: "ebc8a441-c6f9-11e4-b137-0adc305c3f21", sysRoleId: "001",…}
    id: "ebc8a441-c6f9-11e4-b137-0adc305c3f21"
    sysPermissionId: "11,12,13,21,22,23,31,32,33,61,62,63,71,72,73,81,82,83,91,92,93,101,102,103,111,112,113,121,122,123,181,182,183,191,192,193,221,222,223,131,132,133,141,142,143,151,152,153,161,162,163,171,172,173,231,232,233,271,272,273,241,242,243,251,252,253,261,262,263,41,42,43,51,52,53,201,202,203,211,212,"
    sysRoleId: "001"*/

    @RequestMapping("role/get/{role_id}")
    @ResponseBody
    public UserRole role(@PathVariable("role_id")int role_id) {
        UserRole userRole = userRoleService.selectByPrimaryKey(role_id);
        return userRole;
    }


    @RequestMapping("user/role")
    public String userRole() {
        return "user_role_edit";
    }


    @RequestMapping("role/find")
    @ResponseBody
    public Vo<UserRole> roleFind() {
        Vo<UserRole> userRoleVo = userRoleService.findSysUserPage();
        return userRoleVo;
    }





    @RequestMapping("user/add")
    public String userAdd() {

        return "user_add";
    }

    @RequestMapping("user/add_judge")
    @ResponseBody
    public SysUser userAddJudge() {
        return null;
    }

    @RequestMapping("role/get_data")
    @ResponseBody
    public List<UserRole> roleGet_data() {
        List<UserRole> userRoles = userRoleService.selectUserRoleList();
        return userRoles;
    }


    @RequestMapping("user/insert")
    @ResponseBody
    public ResponseVo submitAdduser(SysUser sysUser) {
        String password = sysUser.getPassword();
        String md5 = MD5Utils.getMD5(password);
        sysUser.setPassword(md5);
        sysUser.setMd5(password);
        sysUser.setLocked("1");
        int i = sysUserService.insertSelective(sysUser);
        ResponseVo responseVo = responseVo(i);
        return responseVo;
    }

    private ResponseVo responseVo(int i) {
        if (i == 1) {
            ResponseVo responseVo = new ResponseVo();
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
            responseVo.setData(null);
            return responseVo;
        } else {
            return null;
        }
    }


}
