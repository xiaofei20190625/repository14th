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
    public COrder selectByPrimaryKey(String orderId) {
        COrder cOrder = cOrderMapper.selectByPrimaryKey(orderId);
        return cOrder;
    }

    @Override
    public List<COrder> selectByExample(COrderExample example) {

        List<COrder> cOrders = cOrderMapper.selectByExample(example);
        return cOrders;
    }

    @Override
    public long countByExample(COrderExample example) {
        long l = cOrderMapper.countByExample(example);
        return l;
    }
}
