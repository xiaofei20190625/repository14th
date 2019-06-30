package com.cskaoyan.mapper;

import com.cskaoyan.bean.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    int insertSelective2(@Param("password")String password, @Param("md5")String md5);

    SysUser selectByPrimaryKey(@Param("username") String username);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> selectSysUserlist();

}