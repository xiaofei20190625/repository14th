package com.cskaoyan.service;

import com.cskaoyan.bean.Product;
import com.cskaoyan.vo.Vo;

public interface ProductService {
    Product selectByPrimaryKey(String productId);

    Vo<Product> findProductPage(int page, int rows);
}
