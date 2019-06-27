package com.cskaoyan.mapper;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> findTechnology();

    Technology getTechnology(@Param("tid")int tid);
}