package com.cskaoyan.service;

import com.cskaoyan.bean.FinalMeasuretCheck;
import com.cskaoyan.vo.Vo;

public interface FinalMeasureService {

    Vo<FinalMeasuretCheck> queryAllFinalMeasuretCheck(int page, int rows);

    int insertSelective(FinalMeasuretCheck record);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int deleteByIds(String[] ids);

    Vo<FinalMeasuretCheck> fuzzyQueryUnqualifyById(String FinalMeasuretCheckId, int page, int rows);

    Vo<FinalMeasuretCheck> fuzzyQueryUnqualifyByProductName(String searchValue, int page, int rows);

}
