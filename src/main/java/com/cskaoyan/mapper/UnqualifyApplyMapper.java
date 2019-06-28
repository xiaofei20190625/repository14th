package com.cskaoyan.mapper;

import com.cskaoyan.bean.UnqualifyApply;

import java.util.List;

public interface UnqualifyApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    int deleteByIds(String[] ids);

    List<UnqualifyApply> queryAllUnqualifyApply();

    List<UnqualifyApply> fuzzyQueryUnqualifyById(String unqualifyApplyId);

    List<UnqualifyApply> fuzzyQueryUnqualifyByProductName(String productName);
}