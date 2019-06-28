package com.cskaoyan.mapper;

import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(@Param("tr")TechnologyRequirement tr);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> findTechnologyRequirement();

    int deleteTechnologyRequirementList(@Param("ids") String[] ids);

    List<TechnologyRequirement> searchTechnologyRequirementById(@Param("searchValue") String searchValue);

    List<TechnologyRequirement> searchTechnologyRequirementByTechnologyName(@Param("searchValue")String searchValue);
}