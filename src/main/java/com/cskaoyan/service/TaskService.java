package com.cskaoyan.service;

import com.cskaoyan.bean.Task;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface TaskService {
    List<Task> selectTask();
    Vo<Task> findTaskPage(int pag, int rows);
}
