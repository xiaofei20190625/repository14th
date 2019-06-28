package com.cskaoyan.controller;

import java.util.List;
import javax.validation.Valid;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.service.DeviceTypeService;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
	@Autowired
	 DeviceTypeService deviceTypeService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Vo getListType(Integer page, Integer rows, DeviceType deviceType) {
		Vo result = deviceTypeService.getList(page, rows, deviceType);
		return result;
	}
	
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public DeviceType getItemById(@PathVariable String orderId) {
		DeviceType device = deviceTypeService.get(orderId);
		return device;
	}
	
	//回显设备种类
	@RequestMapping("/get_data")
	@ResponseBody
	public List<DeviceType> getData() {
		List<DeviceType> list = deviceTypeService.getData();
		return list;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "deviceType_add";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "deviceType_edit";
	}
	 
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private DeviceResult insert(@Valid DeviceType deviceType, BindingResult bindingResult)  {
		DeviceResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return DeviceResult.build(100, fieldError.getDefaultMessage());
		}
		if(deviceTypeService.get(deviceType.getDeviceTypeId()) != null){
			result = new DeviceResult(0, "该设备种类编号已经存在，请更换设备种类编号！", null);
		}else{
			result = deviceTypeService.insert(deviceType);
		}
		return result;
	}

	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private DeviceResult deleteBatch(String[] ids)  {
		DeviceResult result = deviceTypeService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private DeviceResult update(@Valid DeviceType deviceType, BindingResult bindingResult)  {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return DeviceResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceTypeService.update(deviceType);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private DeviceResult updateAll(@Valid DeviceType deviceType, BindingResult bindingResult)  {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return DeviceResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceTypeService.updateAll(deviceType);
	}
	
	//根据设备种类编号查找
	@RequestMapping("/search_deviceType_by_deviceTypeId")
	@ResponseBody
	public Vo searchDeviceTypeByDeviceTypeId(Integer page, Integer rows, String searchValue) 
			{
		Vo result = deviceTypeService.searchDeviceTypeByDeviceTypeId(page, rows, searchValue);
		return result;
	}
	
	//根据设备种类名称查找
	@RequestMapping("/search_deviceType_by_deviceTypeName")
	@ResponseBody
	public Vo searchDeviceTypeByDeviceTypeName(Integer page, Integer rows, String searchValue) 
			{
		Vo result = deviceTypeService.searchDeviceTypeByDeviceTypeName(page, rows, searchValue);
		return result;
	}
}
