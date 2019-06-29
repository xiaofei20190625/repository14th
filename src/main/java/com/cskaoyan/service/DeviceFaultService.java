package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;

import java.util.List;



public interface DeviceFaultService {

	Vo getList(int page, int rows, DeviceFault deviceFault) ;
	
	DeviceFault get(String string) ;
	
	List<DeviceFault> find() ;

	DeviceResult insert(DeviceFault deviceFault) ;
	
	DeviceResult delete(String deviceFaultId) ;
	
	DeviceResult deleteBatch(String[] deviceFaultIds) ;

    DeviceResult update(DeviceFault deviceFault) ;

	DeviceResult updateNote(DeviceFault deviceFault) ;

	DeviceResult updateAll(DeviceFault deviceFault) ;

	Vo searchDeviceFaultByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) ;

	Vo searchDeviceFaultByDeviceName(Integer page, Integer rows,
			String deviceName) ;
}
