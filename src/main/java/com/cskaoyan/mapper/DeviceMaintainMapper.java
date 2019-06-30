
package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceMaintain;

import java.util.List;

public interface DeviceMaintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    List<DeviceMaintain> getList(DeviceMaintain deviceMaintain);

    int deleteBatch(String[] deviceMaintainIds);

    int updateNote(DeviceMaintain deviceMaintain);

    List<DeviceMaintain> searchDeviceMaintainByDeviceMaintainId(String deviceMaintainId);

    List<DeviceMaintain> searchDeviceMaintainByDeviceFaultId(String deviceFaultId);

}