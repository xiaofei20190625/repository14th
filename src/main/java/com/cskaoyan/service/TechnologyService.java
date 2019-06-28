package com.cskaoyan.service;

import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.vo.Vo;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 17:42
 */
public interface TechnologyService {
    //---------------工艺管理---------------
    Vo<Technology> findTechnology(int page, int rows);
    List<Technology> findAllTechnology();
    Technology getTechnology(int tid);
    int insertTechnology(Technology technology);
    int updateTechnology(Technology technology);
    int deleteTechnologyList(String[] ids);
    Vo<Technology> searchTechnologyById(String searchValue, int page, int rows);
    Vo<Technology> searchTechnologyByName(String searchValue, int page, int rows);

    //---------------工艺要求---------------

    Vo<TechnologyRequirement> findTechnologyRequirement(int page, int rows);
    List<TechnologyRequirement> findAllTechnologyRequirement();
    int insertTechnologyRequirement(TechnologyRequirement technologyRequirement);

    //---------------工艺计划---------------
    Vo<TechnologyPlan> findTechnologyPlan(int page, int rows);

    //查询工艺计划

    TechnologyPlan getTechnologyPlan(int planid);

    //---------------工序管理---------------

    Vo<Process> findProcess(int page, int rows);

}

