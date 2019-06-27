package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyService;
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

    @Override
    public List<Technology> findAllTechnology() {
        List<Technology> allTechnologies = technologyMapper.findAllTechnologies();
        return allTechnologies;
    }

    @Override
    public List<Technology> findPageTechnology(int page, int rows) {
        int offset = (page - 1) * rows;//计算偏移量
        return technologyMapper.findPageTechnologies(offset, rows);
    }

    @Override
    public List<TechnologyRequirement> findAllTechnologyRequirement() {
        return null;
    }
}
