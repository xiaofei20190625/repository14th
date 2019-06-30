package com.cskaoyan.service;

import com.cskaoyan.bean.FinalCountCheck;
import com.cskaoyan.vo.Vo;

public interface FinalCountService {

    Vo<FinalCountCheck> queryAllFinalCountCheck(int page, int rows);

    int insertSelective(FinalCountCheck record);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int deleteByIds(String[] ids);

    Vo<FinalCountCheck> fuzzyQueryFinalCountCheckById(String searchValue, int page, int rows);

    Vo<FinalCountCheck> fuzzyQueryFinalCountCheckByOrderId(String searchValue, int page, int rows);

}
