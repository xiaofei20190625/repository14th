package com.cskaoyan.service;


import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.customiz.CustomResult;
import com.cskaoyan.customiz.EUDataGridResult;

public interface DeviceMaintainService {

	EUDataGridResult getList(int page, int rows, DeviceMaintain deviceMaintain) throws Exception;
	
	DeviceMaintain get(String string) throws Exception;
	
	CustomResult insert(DeviceMaintain deviceMaintain) throws Exception;
	
	CustomResult delete(String deviceMaintainId) throws Exception;
	
	CustomResult deleteBatch(String[] deviceMaintainIds) throws Exception;

    CustomResult update(DeviceMaintain deviceMaintain) throws Exception;

	CustomResult updateNote(DeviceMaintain deviceMaintain) throws Exception;

	EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page,
			Integer rows, String deviceMaintainId) throws Exception;

	EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) throws Exception;
}
