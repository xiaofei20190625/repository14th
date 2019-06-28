package com.cskaoyan.mapper;

import com.cskaoyan.bean.Task;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    List<Task> selectTask();

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}