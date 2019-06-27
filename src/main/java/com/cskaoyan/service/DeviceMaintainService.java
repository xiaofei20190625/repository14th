package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.customiz.CustomResult;
import com.cskaoyan.vo.Vo;

import java.util.List;


public interface DeviceMaintainService {

	Vo getList(int page, int rows, DeviceMaintain deviceMaintain) ;
	
	DeviceMaintain get(String string) ;
	
	CustomResult insert(DeviceMaintain deviceMaintain) ;
	
	CustomResult delete(String deviceMaintainId) ;
	
	CustomResult deleteBatch(String[] deviceMaintainIds) ;

    CustomResult update(DeviceMaintain deviceMaintain) ;

	CustomResult updateNote(DeviceMaintain deviceMaintain) ;

	Vo searchDeviceMaintainByDeviceMaintainId(Integer page,
			Integer rows, String deviceMaintainId) ;

	Vo searchDeviceMaintainByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) ;

	List<DeviceMaintain> find();
}
