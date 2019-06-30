package com.cskaoyan.service;

import com.cskaoyan.bean.UserRole;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface UserRoleService {
    UserRole selectByPrimaryKey(Integer id);

    Vo<UserRole> findSysUserPage();

    List<UserRole> selectUserRoleList();

}
