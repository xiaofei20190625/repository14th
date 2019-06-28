package com.cskaoyan.service;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> selectManufactureList();
    Vo<Manufacture> findManufacturePage(int page,int rows);
    Manufacture selectManufacture(String manufactureSn);
}
