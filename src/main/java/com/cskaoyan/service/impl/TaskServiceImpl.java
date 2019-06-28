package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Task;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.TaskService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Override
    public List<Task> selectTask() {
        return taskMapper.selectTask();
    }

    @Override
    public Vo<Task> findTaskPage(int pag, int rows) {
        PageHelper.startPage(pag, rows);
        List<Task> tasks = taskMapper.selectTask();
        PageInfo<Task> taskPageInfo = new PageInfo<>(tasks);
        Vo<Task> taskVo = new Vo<>(taskPageInfo.getTotal(), taskPageInfo.getList());
        return taskVo;
    }
}
