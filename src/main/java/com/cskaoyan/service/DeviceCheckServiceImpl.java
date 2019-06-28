package com.cskaoyan.service;

import java.util.List;

import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.customiz.CustomResult;
import com.cskaoyan.mapper.DeviceCheckMapper;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService{

	@Autowired
	DeviceCheckMapper deviceCheckMapper;
	
	@Override
	public Vo getList(int page, int rows, DeviceCheck deviceCheck) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceCheck> list = deviceCheckMapper.find(deviceCheck);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceCheck get(String id) throws Exception {
		return deviceCheckMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public CustomResult insert(DeviceCheck deviceCheck) throws Exception {
		int i = deviceCheckMapper.insert(deviceCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备例检失败");
		}
	}

	@Override
	public CustomResult delete(String deviceCheckId) throws Exception {
		int i = deviceCheckMapper.deleteByPrimaryKey(deviceCheckId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceCheckIds) throws Exception {
		int i = deviceCheckMapper.deleteBatch(deviceCheckIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceCheck deviceCheck) throws Exception {
		int i = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备例检失败");
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
	public CustomResult updateNote(DeviceCheck deviceCheck) throws Exception {
		int i = deviceCheckMapper.updateNote(deviceCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改例检结果失败");
		}
	}
}
