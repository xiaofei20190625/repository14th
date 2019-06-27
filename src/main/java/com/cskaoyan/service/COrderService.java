package com.cskaoyan.service;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;

import java.util.List;

public interface COrderService {
    COrder selectByPrimaryKey(String orderId);
    List<COrder> selectByExample(COrderExample example);
    long countByExample(COrderExample example);
}
