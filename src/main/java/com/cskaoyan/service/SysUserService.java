package com.cskaoyan.service;


import com.cskaoyan.bean.SysUser;
import com.cskaoyan.vo.Login;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface SysUserService {

    Login loginSysUser(String username, String password);

    Vo<SysUser> findSysUserPage(int page, int rows);

    SysUser selectByPrimaryKey(String username);

    int insertSelective(SysUser sysUser);
}
