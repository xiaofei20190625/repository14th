
package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;

import java.util.List;


public interface DeviceMaintainService {

	Vo getList(int page, int rows, DeviceMaintain deviceMaintain) ;
	
	DeviceMaintain get(String string) ;
	
	DeviceResult insert(DeviceMaintain deviceMaintain) ;
	
	DeviceResult delete(String deviceMaintainId) ;
	
	DeviceResult deleteBatch(String[] deviceMaintainIds) ;

    DeviceResult update(DeviceMaintain deviceMaintain) ;

	DeviceResult updateNote(DeviceMaintain deviceMaintain) ;

	Vo searchDeviceMaintainByDeviceMaintainId(Integer page,
			Integer rows, String deviceMaintainId) ;

	Vo searchDeviceMaintainByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) ;

	List<DeviceMaintain> find();
}

