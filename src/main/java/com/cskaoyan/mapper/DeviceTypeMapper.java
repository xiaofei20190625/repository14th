package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insertDeviceType(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> getData();

    List<Device> getList(DeviceType deviceType);

    int deleteBatch(String[] deviceTypeIds);

    List<Device> searchDeviceTypeByDeviceTypeId(String deviceTypeId);

    List<Device> searchDeviceTypeByDeviceTypeName(String deviceTypeName);
}