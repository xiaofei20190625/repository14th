package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface DeviceTypeService {
	
	Vo getList(int page, int rows, DeviceType deviceType) ;
	
	DeviceType get(String string) ;
	
	List<DeviceType> getData() ;
	
	DeviceResult insert(DeviceType deviceType) ;
	
	DeviceResult deleteBatch(String[] deviceTypeIds) ;

    DeviceResult update(DeviceType deviceType) ;
    
    //更新全部字段，不判断非空，直接进行更新
    DeviceResult updateAll(DeviceType deviceType) ;

	Vo searchDeviceTypeByDeviceTypeId(Integer page, Integer rows,
			String deviceTypeId) ;

	Vo searchDeviceTypeByDeviceTypeName(Integer page,
										Integer rows, String deviceTypeName) ;


}
