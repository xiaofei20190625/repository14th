package com.cskaoyan.service.impl;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.Custom;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    CustomMapper customMapper;
    @Override
    public Custom selectByPrimaryKey(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public Vo<Custom> findCustomPage(int pag, int rows) {
        PageHelper.startPage(pag,rows);
        List<Custom> customs = customMapper.selectCustomList();
        PageInfo<Custom> customPageInfo = new PageInfo<>(customs);
        Vo<Custom> customVo = new Vo<>(customPageInfo.getTotal(), customPageInfo.getList());
        return customVo;
    }

    @Override
    public List<Custom> selectCustomList() {
        return customMapper.selectCustomList();
    }
}
