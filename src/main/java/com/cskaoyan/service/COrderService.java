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
    COrder selectByPrimaryKey(String orderId);


    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);


    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    Vo<COrder> searchCOderById(int pag, int rows,String orderId);

    Vo<COrder> searchCOderByOrderCustom(int pag, int rows,String searchValue);

    Vo<COrder> searchCOderByOrderProduct(int pag, int rows,String searchValue);

    int deleteByPrimaryKeys(String[] ids);
}
