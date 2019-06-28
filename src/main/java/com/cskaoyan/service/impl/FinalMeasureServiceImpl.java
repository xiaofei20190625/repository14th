package com.cskaoyan.service.impl;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.mapper.FinalMeasuretCheckMapper;
import com.cskaoyan.service.FinalMeasureService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalMeasureServiceImpl implements FinalMeasureService {
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Override
    public Vo<FinalMeasuretCheck> queryAllFinalMeasuretCheck(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheck> finalMeasuretChecks = finalMeasuretCheckMapper.queryAllFinalMeasuretCheck();
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasuretChecks);
        Vo<FinalMeasuretCheck> finalMeasuretCheckVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return finalMeasuretCheckVo;
    }

    @Override
    public int insertSelective(FinalMeasuretCheck record) {
        return finalMeasuretCheckMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(FinalMeasuretCheck record) {
        int update = finalMeasuretCheckMapper.updateByPrimaryKeySelective(record);
        return update;
    }

    @Override
    public int deleteByIds(String[] ids) {
        int delete = finalMeasuretCheckMapper.deleteByIds(ids);
        return delete;
    }

    @Override
    public Vo<FinalMeasuretCheck> fuzzyQueryFinalMeasuretCheckById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheck> unqualifyApplies = finalMeasuretCheckMapper.fuzzyQueryFinalMeasuretCheckById("%" + searchValue + "%");
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(unqualifyApplies);
        Vo<FinalMeasuretCheck> FinalMeasuretCheckVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return FinalMeasuretCheckVo;
    }

    @Override
    public Vo<FinalMeasuretCheck> fuzzyQueryFinalMeasuretCheckByOrderId(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<FinalMeasuretCheck> unqualifyApplies = finalMeasuretCheckMapper.fuzzyQueryFinalMeasuretCheckByOrderId("%" + searchValue + "%");
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(unqualifyApplies);
        Vo<FinalMeasuretCheck> FinalMeasuretCheckVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return FinalMeasuretCheckVo;
    }
}
