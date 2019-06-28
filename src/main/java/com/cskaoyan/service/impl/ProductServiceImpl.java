package com.cskaoyan.service.impl;


import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Product;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public Product selectByPrimaryKey(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> selectProductList() {
        return productMapper.selectProductList();
    }

    @Override
    public Vo<Product> findProductPage(int page, int rows) {

        PageHelper.startPage(page,rows);
        List<Product> products = productMapper.selectProductList();
        PageInfo<Product> productPageInfo = new PageInfo<>(products);
        Vo<Product> productVo = new Vo<>(productPageInfo.getTotal(), productPageInfo.getList());
        return productVo;
    }

    @Override
    public List<Product> selectProductList() {
        return productMapper.selectProductList();
    }
}

