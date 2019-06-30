package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalCountCheck;

import java.util.List;

public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int deleteByIds(String[] ids);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    List<FinalCountCheck> selectAll();

    List<FinalCountCheck> fuzzyQueryFinalCountCheckById(String searchValue);

    List<FinalCountCheck> fuzzyQueryFinalCountCheckByOrderId(String searchValue);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}