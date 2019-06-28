package com.cskaoyan.mapper;

import com.cskaoyan.bean.Work;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    List<Work> selectWorkList();

    Work selectWork(String workId);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}