package com.cskaoyan.service.impl;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;
import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.service.COrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class COrderServiceImpl implements COrderService {
    @Autowired
    COrderMapper cOrderMapper;

    @Override
    public List<COrder> selectCOrderlist() {
        return cOrderMapper.selectCOrderlist();
    }

    @Override
    public Long countCOrder() {
        return cOrderMapper.countCOrder();
    }
}
