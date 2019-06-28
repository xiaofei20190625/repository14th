package com.cskaoyan.mapper;

import com.cskaoyan.bean.COrder;

import java.util.List;


public interface COrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    List<COrder> selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    List<COrder> selectCOrderlist();

    Long countCOrder();


}