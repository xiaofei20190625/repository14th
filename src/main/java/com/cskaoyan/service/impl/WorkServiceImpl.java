package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Work;
import com.cskaoyan.mapper.WorkMapper;
import com.cskaoyan.service.WorkService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;
    @Override
    public List<Work> selectWorkList() {
        return workMapper.selectWorkList();
    }

    @Override
    public Vo<Work> findWorkPage(int pag, int rows) {

        PageHelper.startPage(pag,rows);
        List<Work> works = workMapper.selectWorkList();
        PageInfo<Work> workPageInfo = new PageInfo<>(works);
        Vo<Work> workVo = new Vo<>(workPageInfo.getTotal(), workPageInfo.getList());
        return workVo;
    }


}
