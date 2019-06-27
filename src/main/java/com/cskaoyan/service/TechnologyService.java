package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.vo.Vo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/26 Time 17:42
 */
public interface TechnologyService {
    //工艺管理
    Vo<Technology> findTechnology(int page, int rows);

    //工艺要求
    Vo<TechnologyRequirement> findTechnologyRequirement(int page, int rows);

    //查询工艺
    Technology getTechnology(int tid);
}
