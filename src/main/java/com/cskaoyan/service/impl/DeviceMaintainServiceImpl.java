
package com.cskaoyan.service.impl;

import java.util.List;


import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.mapper.DeviceMaintainMapper;
import com.cskaoyan.service.DeviceMaintainService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

	@Autowired
	DeviceMaintainMapper deviceMaintainMapper;
	@Override
	public Vo getList(int page, int rows, DeviceMaintain deviceMaintain)  {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceMaintain> list = deviceMaintainMapper.getList(deviceMaintain);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceMaintain get(String id)  {
		return deviceMaintainMapper.selectByPrimaryKey(id);
	}

	@Override
	public DeviceResult insert(DeviceMaintain deviceMaintain)  {
		int i = deviceMaintainMapper.insert(deviceMaintain);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return DeviceResult.build(101, "新增设备维修信息失败");
		}
	}

	@Override
	public DeviceResult delete(String deviceMaintainId)  {
		int i = deviceMaintainMapper.deleteByPrimaryKey(deviceMaintainId);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public DeviceResult deleteBatch(String[] deviceMaintainIds)  {
		int i = deviceMaintainMapper.deleteBatch(deviceMaintainIds);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public DeviceResult update(DeviceMaintain deviceMaintain)  {
		int i = deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return DeviceResult.build(101, "修改设备维修信息失败");
		}
	}

	@Override
	public DeviceResult updateNote(DeviceMaintain deviceMaintain)  {
		int i = deviceMaintainMapper.updateNote(deviceMaintain);
		if(i>0){
			return DeviceResult.ok();
		}else{
			return DeviceResult.build(101, "新增设备维修备注失败");
		}
	}

	@Override
	public Vo searchDeviceMaintainByDeviceMaintainId(
			Integer page, Integer rows, String deviceMaintainId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceMaintain> list = deviceMaintainMapper.searchDeviceMaintainByDeviceMaintainId(deviceMaintainId);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Vo searchDeviceMaintainByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceMaintain> list = deviceMaintainMapper.searchDeviceMaintainByDeviceFaultId(deviceFaultId);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public List<DeviceMaintain> getData() {
		List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.getList(new DeviceMaintain());
		return deviceMaintains;
	}
}

