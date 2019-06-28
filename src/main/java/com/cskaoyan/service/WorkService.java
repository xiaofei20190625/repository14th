package com.cskaoyan.service;

import com.cskaoyan.bean.Work;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface WorkService {
    List<Work> selectWorkList();
    Vo<Work> findWorkPage(int pag, int rows);

    Work getWork(String wid);

    List<Work> findAllWork();
}
