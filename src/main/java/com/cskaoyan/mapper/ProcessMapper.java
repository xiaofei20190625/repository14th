package com.cskaoyan.mapper;

import com.cskaoyan.bean.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);


    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> findProcess();

    int deleteProcessList(@Param("ids") String[] ids);

    List<Process> searchProcessByProcessId(@Param("searchValue")String searchValue);

    List<Process> searchProcessByTechnologyPlanId(@Param("searchValue")String searchValue);
}