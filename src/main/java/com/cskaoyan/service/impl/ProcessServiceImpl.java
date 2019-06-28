package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public Process selectByPrimaryKey(String processId) {
        Process process = processMapper.selectByPrimaryKey(processId);
        return process;
    }
}
