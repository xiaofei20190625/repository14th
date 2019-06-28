package com.cskaoyan.mapper;

import com.cskaoyan.bean.Manufacture;

import java.util.List;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    List<Manufacture> selectManufactureList();

    Manufacture selectManufacture(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);
}