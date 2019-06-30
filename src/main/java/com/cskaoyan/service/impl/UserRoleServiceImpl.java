package com.cskaoyan.service.impl;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.bean.UserRole;
import com.cskaoyan.mapper.UserRoleMapper;
import com.cskaoyan.service.UserRoleService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public UserRole selectByPrimaryKey(Integer id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Vo<UserRole> findSysUserPage() {
        List<UserRole> userRoles = userRoleMapper.selectSysUserlist();
        PageInfo<UserRole> userRolePageInfo = new PageInfo<>(userRoles);
        Vo<UserRole> userRoleVo = new Vo<>(userRolePageInfo.getTotal(), userRolePageInfo.getList());
        return userRoleVo;
    }

    @Override
    public List<UserRole> selectUserRoleList() {
        return userRoleMapper.selectSysUserlist();
    }
}
