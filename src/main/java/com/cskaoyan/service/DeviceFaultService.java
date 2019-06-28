package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;

import java.util.List;



public interface DeviceFaultService {

	Vo getList(int page, int rows, DeviceFault deviceFault) throws Exception;
	
	DeviceFault get(String string) throws Exception;
	
	List<DeviceFault> find() throws Exception;

	DeviceResult insert(DeviceFault deviceFault) throws Exception;
	
	DeviceResult delete(String deviceFaultId) throws Exception;
	
	DeviceResult deleteBatch(String[] deviceFaultIds) throws Exception;

    DeviceResult update(DeviceFault deviceFault) throws Exception;

	DeviceResult updateNote(DeviceFault deviceFault) throws Exception;

	DeviceResult updateAll(DeviceFault deviceFault) throws Exception;

	Vo searchDeviceFaultByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) throws Exception;

	Vo searchDeviceFaultByDeviceName(Integer page, Integer rows,
			String deviceName) throws Exception;
}
