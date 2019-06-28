package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 17:47
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;

    @Autowired
    TechnologyPlanMapper technologyPlanMapper;
    @Autowired
    ProcessMapper processMapper;

    //==================================================================================================
    //---------------工艺管理---------------
    @Override
    public Vo<Technology> findTechnology(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.findTechnology();
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        Vo<Technology> technologyList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyList;
    }
    @Override
    public List<Technology> findAllTechnology() {
        return technologyMapper.findTechnology();
    }
    //查询指定工艺
    @Override
    public Technology getTechnology(int tid) {
        return technologyMapper.getTechnology(tid);
    }
    @Override
    public int insertTechnology(Technology technology) {
        int insert = technologyMapper.insert(technology);
        return insert;
    }
    @Override
    public int updateTechnology(Technology technology) {
        return technologyMapper.updateByPrimaryKeySelective(technology);
    }
    @Override
    public int deleteTechnologyList(String[] ids) {
        return technologyMapper.deleteTechnologyList(ids);
    }
    @Override
    public Vo<Technology> searchTechnologyById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.searchTechnologyById(searchValue);
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        Vo<Technology> technologyList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyList;
    }

    @Override
    public Vo<Technology> searchTechnologyByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<Technology> technologies = technologyMapper.searchTechnologyByName(searchValue);
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        Vo<Technology> technologyList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyList;
    }












}

