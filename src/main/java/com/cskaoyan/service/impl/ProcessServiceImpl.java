
package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:59
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public Vo<Process> findProcess(int page, int rows) {
        //开启分页
        PageHelper.startPage(page, rows);
        //查询technologyRequirement
        List<Process> processes = processMapper.findProcess();
        PageInfo<Process> pageInfo = new PageInfo<>(processes);
        Vo<Process> processVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return processVo;
    }


    @Override
    public Process selectByPrimaryKey(String processId) {
        Process process = processMapper.selectByPrimaryKey(processId);
        return process;
    }

}

