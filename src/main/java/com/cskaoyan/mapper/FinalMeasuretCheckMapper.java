package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalMeasuretCheck;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    int deleteByIds(String[] ids);

    List<FinalMeasuretCheck> queryAllFinalMeasuretCheck();

    List<FinalMeasuretCheck> fuzzyQueryUnqualifyById(String searchValue);

    List<FinalMeasuretCheck> fuzzyQueryUnqualifyByProductName(String searchValue);
}