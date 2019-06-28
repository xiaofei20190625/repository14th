package com.cskaoyan.mapper;

import com.cskaoyan.bean.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(String workId);

    List<Work> selectWorkList();

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    Work getWork(@Param("wid")String wid);
}