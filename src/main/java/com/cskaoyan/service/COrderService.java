package com.cskaoyan.service;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;

import java.util.List;

public interface COrderService {

    List<COrder> selectCOrderlist();
    Long countCOrder();
}
