
package com.cskaoyan.service;

import com.cskaoyan.bean.Process;
import com.cskaoyan.vo.Vo;

/**
 * Created by IceFloe_Rot
 * Date 2019/6/28 Time 11:59
 */
public interface ProcessService {
    Vo<Process> findProcess(int page, int rows);
    Process selectByPrimaryKey(String processId);

    int insertProcess(Process process);

    int updateProcess(Process process);

    int deleteProcessList(String[] ids);

    Vo<Process> searchProcessByProcessId(String searchValue, int page, int rows);

    Vo<Process> searchProcessByTechnologyPlanId(String searchValue, int page, int rows);
}

