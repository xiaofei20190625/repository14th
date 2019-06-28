package com.cskaoyan.mapper;

import com.cskaoyan.bean.COrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface COrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    List<COrder> selectCOrderlist();

    Long countCOrder();

    List<COrder> searchCOderById(@Param("searchValue")String orderId);

    List<COrder> searchCOderByOrderCustom(@Param("searchValue")String searchValue);

    List<COrder> searchCOderByOrderProduct(@Param("searchValue")String searchValue);

    int deleteByPrimaryKeys(@Param("ids")String[] ids);


}