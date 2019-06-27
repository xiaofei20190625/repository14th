package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.customiz.CustomResult;
import com.cskaoyan.customiz.EUDataGridResult;

import java.util.List;



public interface DeviceFaultService {

	EUDataGridResult getList(int page, int rows, DeviceFault deviceFault) throws Exception;
	
	DeviceFault get(String string) throws Exception;
	
	List<DeviceFault> find() throws Exception;

	CustomResult insert(DeviceFault deviceFault) throws Exception;
	
	CustomResult delete(String deviceFaultId) throws Exception;
	
	CustomResult deleteBatch(String[] deviceFaultIds) throws Exception;

    CustomResult update(DeviceFault deviceFault) throws Exception;

	CustomResult updateNote(DeviceFault deviceFault) throws Exception;

	CustomResult updateAll(DeviceFault deviceFault) throws Exception;

	EUDataGridResult searchDeviceFaultByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) throws Exception;

	EUDataGridResult searchDeviceFaultByDeviceName(Integer page, Integer rows,
			String deviceName) throws Exception;
}
