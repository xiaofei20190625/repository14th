package com.cskaoyan.service;

import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.vo.Vo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:47
 */
public interface TechnologyRequirementService {
    Vo<TechnologyRequirement> findTechnologyRequirement(int page, int rows);
    List<TechnologyRequirement> findAllTechnologyRequirement();
    int insertTechnologyRequirement(TechnologyRequirement technologyRequirement);
    int updateTechnologyRequirement(TechnologyRequirement technologyRequirement);
    int deleteTechnologyRequirementList(String[] ids);
    Vo<TechnologyRequirement> searchTechnologyRequirementById(String searchValue, int page, int rows);
    Vo<TechnologyRequirement> searchTechnologyRequirementByTechnologyName(String searchValue, int page, int rows);
}
