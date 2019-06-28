package com.cskaoyan.service.impl;

import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.mapper.UnqualifyApplyMapper;
import com.cskaoyan.service.UnqualifyApplyService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnqualifyApplyServiceImpl implements UnqualifyApplyService {
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    @Override
    public Vo<UnqualifyApply> queryAllUnqualifyApply(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.queryAllUnqualifyApply();
        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(unqualifyApplies);
        Vo<UnqualifyApply> unqualifyApplyVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return unqualifyApplyVo;
    }

    @Override
    public int insertSelective(UnqualifyApply record) {
        return unqualifyApplyMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UnqualifyApply record) {
        int update = unqualifyApplyMapper.updateByPrimaryKeySelective(record);
        return update;
    }

    @Override
    public int deleteByIds(String[] ids) {
        return unqualifyApplyMapper.deleteByIds(ids);
    }
}
