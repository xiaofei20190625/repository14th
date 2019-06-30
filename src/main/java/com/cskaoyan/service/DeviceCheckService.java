package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.vo.DeviceResult;

import com.cskaoyan.vo.Vo;

public interface DeviceCheckService {
	
	Vo getList(int page, int rows, DeviceCheck deviceCheck) ;
	
	DeviceCheck get(String string) ;

	DeviceResult insertDeviceCheck(DeviceCheck deviceCheck) ;
	
	DeviceResult delete(String deviceCheckId) ;
	
	DeviceResult deleteBatch(String[] deviceCheckIds) ;

    DeviceResult update(DeviceCheck deviceCheck) ;

    DeviceResult updateNote(DeviceCheck deviceCheck) ;
    
	Vo searchDeviceCheckByDeviceCheckId(Integer page,
			Integer rows, String deviceCheckId) ;

	Vo searchDeviceCheckByDeviceName(Integer page, Integer rows,
									 String deviceName) ;


}
