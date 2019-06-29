package com.cskaoyan.service.impl;

import java.util.List;

import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.service.DeviceCheckService;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.mapper.DeviceCheckMapper;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

	@Autowired
	DeviceCheckMapper deviceCheckMapper;
	
	@Override
	public Vo getList(int page, int rows, DeviceCheck deviceCheck)  {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceCheck> list = deviceCheckMapper.getList(deviceCheck);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceCheck get(String id)  {
		return deviceCheckMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public DeviceResult insertDeviceCheck(DeviceCheck deviceCheck)  {
		int i = deviceCheckMapper.insertDeviceCheck(deviceCheck);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return DeviceResult.build(101, "新增设备例检失败");
		}
	}

	@Override
	public DeviceResult delete(String deviceCheckId)  {
		int i = deviceCheckMapper.deleteByPrimaryKey(deviceCheckId);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public DeviceResult deleteBatch(String[] deviceCheckIds)  {
		int i = deviceCheckMapper.deleteBatch(deviceCheckIds);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public DeviceResult update(DeviceCheck deviceCheck)  {
		int i = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
		if(i>=0){
			return DeviceResult.ok();
		}else{
			return DeviceResult.build(101, "修改设备例检失败");
		}
	}

	@Override
	public Vo searchDeviceCheckByDeviceCheckId(Integer page,
			Integer rows, String deviceCheckId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceCheck> list = deviceCheckMapper.searchDeviceCheckByDeviceCheckId(deviceCheckId);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Vo searchDeviceCheckByDeviceName(Integer page,
			Integer rows, String deviceName) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceCheck> list = deviceCheckMapper.searchDeviceCheckByDeviceName(deviceName);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public DeviceResult updateNote(DeviceCheck deviceCheck)  {
		int i = deviceCheckMapper.updateNote(deviceCheck);
		if(i>0){
			return DeviceResult.ok();
		}else{
			return DeviceResult.build(101, "修改例检结果失败");
		}
	}
}
