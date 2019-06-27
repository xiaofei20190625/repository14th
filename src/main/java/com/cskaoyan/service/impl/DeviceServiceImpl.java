package com.cskaoyan.service.impl;

import java.util.List;

import com.cskaoyan.bean.Device;
import com.cskaoyan.customiz.CustomResult;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeviceServiceImpl implements  DeviceService  {

	@Autowired
	DeviceMapper deviceMapper;
	@Override
	public Vo getList(int page, int rows, Device device)  {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.find(device);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public List<Device> find()  {
		List<Device> deviceList = deviceMapper.getData();
		return deviceList;
	}

	
	@Override
	public Device get(String id)  {
		return deviceMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public CustomResult insert(Device device)  {
		int i = deviceMapper.insert(device);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备信息失败");
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceIds)  {
		int i = deviceMapper.deleteBatch(deviceIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(Device device)  {
		System.out.println("device update service");
		System.out.println(device.getNote());
		//System.out.println(JsonUtils.objectToJson(device));
		int i = deviceMapper.updateByPrimaryKeySelective(device);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备信息失败");
		}
	}

	@Override
	public CustomResult updateNote(Device device)  {
		int i = deviceMapper.updateNote(device);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备备注失败");
		}
	}
	
	@Override
	public CustomResult updateAll(Device device)  {
		int i = deviceMapper.updateByPrimaryKey(device);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备信息失败");
		}
	}

	@Override
	public Vo searchDeviceByDeviceId(Integer page, Integer rows,
			String deviceId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.searchDeviceByDeviceId(deviceId);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Vo searchDeviceByDeviceName(Integer page,
			Integer rows, String deviceName) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.searchDeviceByDeviceName(deviceName);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Vo searchDeviceByDeviceTypeName(Integer page,
			Integer rows, String deviceTypeName) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.searchDeviceByDeviceTypeName(deviceTypeName);
		//创建一个返回值对象
		Vo result = new Vo();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
