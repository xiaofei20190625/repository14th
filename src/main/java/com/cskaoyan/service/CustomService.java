package com.cskaoyan.service;


import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Product;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface CustomService {
    Custom selectByPrimaryKey(String customId);
    Vo<Custom> findCustomPage(int pag, int rows);
    List<Custom> selectCustomList();

}
