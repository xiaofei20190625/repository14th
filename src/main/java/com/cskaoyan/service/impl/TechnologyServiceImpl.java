package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.TechnologyMapper;
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
    TechnologyRequirementMapper technologyRequirementMapper;

    //工艺管理
    @Override
    public Vo<Technology> findTechnology(int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);
        //查询technology
        List<Technology> technologies = technologyMapper.findTechnology();
        PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
        Vo<Technology> technologyList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyList;
    }

    //工艺要求
    @Override
    public Vo<TechnologyRequirement> findTechnologyRequirement(int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);
        //查询technologyRequirement
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.findTechnologyRequirement();
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        Vo<TechnologyRequirement> technologyRequirementVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyRequirementVo;
    }

    @Override
    public Technology getTechnology(int tid) {
        return technologyMapper.getTechnology(tid);
    }
}
