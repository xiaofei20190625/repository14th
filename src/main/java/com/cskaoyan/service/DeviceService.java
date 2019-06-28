
package com.cskaoyan.service;

import java.util.List;

import com.cskaoyan.bean.Device;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;


public interface DeviceService {


	Vo getList(int page, int rows, Device device) ;

	
	List<Device> getData() ;
	
	Device getDeviceId(String string) ;

	DeviceResult insert(Device device) ;
	
	DeviceResult deleteBatch(String[] deviceIds) ;


    DeviceResult update(Device device) ;

	DeviceResult updateNote(Device device) ;

	//更新全部字段，不判断非空，直接进行更新
    DeviceResult updateAll(Device device) ;

	Vo searchDeviceByDeviceId(Integer page, Integer rows,
			String deviceId);

	Vo searchDeviceByDeviceName(Integer page, Integer rows, String deviceName) ;


	Vo searchDeviceByDeviceTypeName(Integer page, Integer rows,
			String deviceTypeName) ;

}

