package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.vo.DeviceResult;

import com.cskaoyan.vo.Vo;

public interface DeviceCheckService {
	
	Vo getList(int page, int rows, DeviceCheck deviceCheck) throws Exception;
	
	DeviceCheck get(String string) throws Exception;

	DeviceResult insert(DeviceCheck deviceCheck) throws Exception;
	
	DeviceResult delete(String deviceCheckId) throws Exception;
	
	DeviceResult deleteBatch(String[] deviceCheckIds) throws Exception;

    DeviceResult update(DeviceCheck deviceCheck) throws Exception;

    DeviceResult updateNote(DeviceCheck deviceCheck) throws Exception;
    
	Vo searchDeviceCheckByDeviceCheckId(Integer page,
			Integer rows, String deviceCheckId) throws Exception;

	Vo searchDeviceCheckByDeviceName(Integer page, Integer rows,
									 String deviceName) throws Exception;
}
