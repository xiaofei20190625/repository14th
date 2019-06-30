package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.mapper.FinalCountCheckMapper;
import com.cskaoyan.service.FinalCountService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCountServiceImpl implements FinalCountService {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Override
    public Vo<FinalCountCheck> queryAllFinalCountCheck(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.selectAll();
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountChecks);
        Vo<FinalCountCheck> finalCountCheckVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return finalCountCheckVo;
    }

    @Override
    public int insertSelective(FinalCountCheck record) {
        return finalCountCheckMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(FinalCountCheck record) {
        return finalCountCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return finalCountCheckMapper.deleteByIds(ids);
    }

    @Override
    public Vo<FinalCountCheck> fuzzyQueryFinalCountCheckById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.fuzzyQueryFinalCountCheckById("%" + searchValue + "%");
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountChecks);
        Vo<FinalCountCheck> finalCountCheckVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return finalCountCheckVo;
    }

    @Override
    public Vo<FinalCountCheck> fuzzyQueryFinalCountCheckByOrderId(String searchValue, int page, int rows) {

        PageHelper.startPage(page, rows);
        List<FinalCountCheck> finalCountChecks = finalCountCheckMapper.fuzzyQueryFinalCountCheckByOrderId("%" + searchValue + "%");
        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountChecks);
        Vo<FinalCountCheck> finalCountCheckVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return finalCountCheckVo;
    }
}
