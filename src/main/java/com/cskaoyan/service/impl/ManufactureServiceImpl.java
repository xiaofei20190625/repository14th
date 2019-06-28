package com.cskaoyan.service.impl;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.ManufactureService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;
    @Override
    public List<Manufacture> selectManufactureList() {
        return manufactureMapper.selectManufactureList();
    }

    @Override
    public Vo<Manufacture> findManufacturePage(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Manufacture> manufactures = manufactureMapper.selectManufactureList();
        PageInfo<Manufacture> manufacturePageInfo = new PageInfo<>(manufactures);
        Vo<Manufacture> manufactureVo = new Vo<>(manufacturePageInfo.getTotal(), manufacturePageInfo.getList());
        return manufactureVo;
    }

    @Override
    public Manufacture selectManufacture(String manufactureSn) {
        return manufactureMapper.selectManufacture(manufactureSn);
    }

}
