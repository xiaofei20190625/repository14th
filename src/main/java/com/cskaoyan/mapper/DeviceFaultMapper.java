package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceFault;

import java.util.List;

public interface DeviceFaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    List<DeviceFault> getData();

    List<DeviceFault> getList(DeviceFault deviceFault);

    int updateNote(DeviceFault deviceFault);

    int deleteBatch(String[] deviceFaultIds);

    List<DeviceFault> searchDeviceFaultByDeviceFaultId(String deviceFaultId);

    List<DeviceFault> searchDeviceFaultByDeviceName(String deviceName);
}