package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.customiz.CustomResult;

import com.cskaoyan.vo.Vo;

public interface DeviceCheckService {
	
	Vo getList(int page, int rows, DeviceCheck deviceCheck) throws Exception;
	
	DeviceCheck get(String string) throws Exception;

	CustomResult insert(DeviceCheck deviceCheck) throws Exception;
	
	CustomResult delete(String deviceCheckId) throws Exception;
	
	CustomResult deleteBatch(String[] deviceCheckIds) throws Exception;

    CustomResult update(DeviceCheck deviceCheck) throws Exception;

    CustomResult updateNote(DeviceCheck deviceCheck) throws Exception;
    
	Vo searchDeviceCheckByDeviceCheckId(Integer page,
			Integer rows, String deviceCheckId) throws Exception;

	Vo searchDeviceCheckByDeviceName(Integer page, Integer rows,
									 String deviceName) throws Exception;
}
