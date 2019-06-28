package com.cskaoyan.service.impl;

import com.cskaoyan.bean.COrder;

import com.cskaoyan.mapper.COrderMapper;
import com.cskaoyan.service.COrderService;

import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        List<COrder> cOrders = cOrderMapper.selectCOrderlist();
        return cOrders;
    }

    @Override
    public Long countCOrder() {
        Long orderNum = cOrderMapper.countCOrder();
        return orderNum;
    }

    @Override
    public Vo<COrder> findCOrderPage(int pag, int rows) {
        PageHelper.startPage(pag,rows);
        List<COrder> cOrders = cOrderMapper.selectCOrderlist();
        PageInfo<COrder> cOrderPageInfo = new PageInfo<>(cOrders);
        Vo<COrder> cOrderVo = new Vo<>(cOrderPageInfo.getTotal(), cOrderPageInfo.getList());

        return cOrderVo;
    }

    @Override
    public Vo<COrder> selectByPrimaryKey(int pag, int rows,String orderId) {
        PageHelper.startPage(pag,rows);
        List<COrder> cOrders = cOrderMapper.selectByPrimaryKey(orderId);
        PageInfo<COrder> cOrderPageInfo = new PageInfo<>(cOrders);
        Vo<COrder> cOrder = new Vo<>(cOrderPageInfo.getTotal(), cOrderPageInfo.getList());
        return cOrder;
    }


}
