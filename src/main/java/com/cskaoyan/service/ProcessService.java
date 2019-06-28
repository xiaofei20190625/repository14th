package com.cskaoyan.service;

import com.cskaoyan.bean.Process;

public interface ProcessService {
    Process selectByPrimaryKey(String processId);
}
