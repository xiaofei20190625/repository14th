package com.cskaoyan.service.impl;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.mapper.SysUserMapper;
import com.cskaoyan.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public SysUser selectByPrimaryKey(String id) {

        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }
}
