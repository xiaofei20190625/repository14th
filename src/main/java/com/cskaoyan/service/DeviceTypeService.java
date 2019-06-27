package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.customiz.CustomResult;
import com.cskaoyan.vo.Vo;

import java.util.List;

public interface DeviceTypeService {
	
	Vo getList(int page, int rows, DeviceType deviceType) throws Exception;
	
	DeviceType get(String string) throws Exception;
	
	List<DeviceType> find() throws Exception;
	
	CustomResult insert(DeviceType deviceType) throws Exception;
	
	CustomResult deleteBatch(String[] deviceTypeIds) throws Exception;

    CustomResult update(DeviceType deviceType) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(DeviceType deviceType) throws Exception;

	Vo searchDeviceTypeByDeviceTypeId(Integer page, Integer rows,
			String deviceTypeId) throws Exception;

	Vo searchDeviceTypeByDeviceTypeName(Integer page,
										Integer rows, String deviceTypeName) throws Exception;
}
