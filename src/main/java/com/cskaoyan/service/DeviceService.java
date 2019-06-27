package com.cskaoyan.service;

import java.util.List;

import com.cskaoyan.bean.Device;
import com.cskaoyan.customiz.CustomResult;
import com.cskaoyan.vo.Vo;


public interface DeviceService {

	Vo getList(int page, int rows, Device device) ;
	
	List<Device> find() ;
	
	Device get(String string) ;

	CustomResult insert(Device device) ;
	
	CustomResult deleteBatch(String[] deviceIds) ;

    CustomResult update(Device device) ;

	CustomResult updateNote(Device device) ;

	//更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Device device) ;

	Vo searchDeviceByDeviceId(Integer page, Integer rows,
			String deviceId);

	Vo searchDeviceByDeviceName(Integer page, Integer rows, String deviceName) ;

	Vo searchDeviceByDeviceTypeName(Integer page, Integer rows,
			String deviceTypeName) ;
}
