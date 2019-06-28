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


}

