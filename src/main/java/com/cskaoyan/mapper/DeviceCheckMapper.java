package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceCheck;

import java.util.List;

public interface DeviceCheckMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

    List<DeviceCheck> find(DeviceCheck deviceCheck);

    int deleteBatch(String[] deviceCheckIds);

    List<DeviceCheck> searchDeviceCheckByDeviceCheckId(String deviceCheckId);

    List<DeviceCheck> searchDeviceCheckByDeviceName(String deviceName);

    int updateNote(DeviceCheck deviceCheck);
}