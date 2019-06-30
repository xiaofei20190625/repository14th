package com.cskaoyan.service.impl;

/*import com.cskaoyan.bean.SysUser;
import com.cskaoyan.mapper.SysUserMapper;
import com.cskaoyan.service.SysUserService;*/
import com.cskaoyan.bean.SysUser;
import com.cskaoyan.mapper.SysUserMapper;
import com.cskaoyan.service.SysUserService;
import com.cskaoyan.vo.Login;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    /**
     *
     * @param username
     * @param password
     * @return {msg: "account_error"}
     *     msg: "account_error"用户不存在
     *     password_error密码错误
     *     randomcode_error验证码错误
     *     authentication_error没有授权
     */
    @Override
    public Login loginSysUser(String username, String password) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(username);
        Login login = new Login();
        if (sysUser==null){
            login.setMsg("account_error");
        }else if (sysUser!=null&&!password.equals(sysUser.getMd5())){
            login.setMsg("password_error");
        }else if (password.equals(sysUser.getMd5())&& !"1".equals(sysUser.getLocked())){
            login.setMsg("authentication_error");
        }else if (password.equals(sysUser.getMd5())&& "1".equals(sysUser.getLocked())){
            login.setMsg("success");
        }else {
            login.setMsg("account_error");
        }
        return login;
    }

    @Override
    public Vo<SysUser> findSysUserPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<SysUser> sysUsers = sysUserMapper.selectSysUserlist();
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(sysUsers);
        Vo<SysUser> sysUserVo = new Vo<>(sysUserPageInfo.getTotal(), sysUserPageInfo.getList());
        return sysUserVo;
    }

    @Override
    public SysUser selectByPrimaryKey(String username) {
        return sysUserMapper.selectByPrimaryKey(username);
    }

    @Override
    public int insertSelective(SysUser sysUser) {
        sysUserMapper.insertSelective2(sysUser.getPassword(),sysUser.getMd5());
        return sysUserMapper.insertSelective(sysUser);
    }
}

