
package com.cskaoyan.mapper;

import com.cskaoyan.bean.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    List<Product> selectProductList();

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

}