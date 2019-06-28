package com.cskaoyan.service;

import com.cskaoyan.bean.COrder;
import com.cskaoyan.bean.COrderExample;
import com.cskaoyan.vo.Vo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface COrderService {

    List<COrder> selectCOrderlist();
    Long countCOrder();
    Vo<COrder> findCOrderPage(int pag, int rows);
    Vo<COrder> selectByPrimaryKey(int pag, int rows,String orderId);
}
