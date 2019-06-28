package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    List<Custom> selectCustomList();

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);
}