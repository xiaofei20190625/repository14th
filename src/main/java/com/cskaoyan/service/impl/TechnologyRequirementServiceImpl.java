package com.cskaoyan.service.impl;

import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:48
 */
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

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
    public List<TechnologyRequirement> findAllTechnologyRequirement() {
        List<TechnologyRequirement> technologyRequirement = technologyRequirementMapper.findTechnologyRequirement();
        return technologyRequirement;
    }

    @Override
    public int insertTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int insert = technologyRequirementMapper.insert(technologyRequirement);
        return insert;
    }

    @Override
    public int updateTechnologyRequirement(TechnologyRequirement technologyRequirement) {
        int update = technologyRequirementMapper.updateByPrimaryKeySelective(technologyRequirement);
        return update;
    }

    @Override
    public int deleteTechnologyRequirementList(String[] ids) {
        return technologyRequirementMapper.deleteTechnologyRequirementList(ids);
    }

    @Override
    public Vo<TechnologyRequirement> searchTechnologyRequirementById(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.searchTechnologyRequirementById(searchValue);
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        Vo<TechnologyRequirement> technologyRequirementVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyRequirementVo;
    }

    @Override
    public Vo<TechnologyRequirement> searchTechnologyRequirementByTechnologyName(String searchValue, int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TechnologyRequirement> technologyRequirements = technologyRequirementMapper.searchTechnologyRequirementByTechnologyName(searchValue);
        PageInfo<TechnologyRequirement> pageInfo = new PageInfo<>(technologyRequirements);
        Vo<TechnologyRequirement> technologyRequirementVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return technologyRequirementVo;
    }
}
