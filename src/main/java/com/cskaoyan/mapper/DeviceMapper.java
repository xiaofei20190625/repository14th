
package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device device);

    List<Device> getList(Device device);

    List<Device> getData();

    int deleteBatch(String[] deviceIds);

    int updateNote(Device device);

    List<Device> searchDeviceByDeviceId(String deviceId);

    List<Device> searchDeviceByDeviceName(String deviceName);

    List<Device> searchDeviceByDeviceTypeName(String deviceTypeName);

}