package com.cskaoyan.controller;


import javax.validation.Valid;
import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.service.DeviceMaintainService;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {
	@Autowired
	private DeviceMaintainService deviceMaintainService;

	@RequestMapping("/list")
	@ResponseBody
	public Vo getListType(Integer page, Integer rows, DeviceMaintain deviceMaintain) {
		return deviceMaintainService.getList(page, rows, deviceMaintain);
	}

	@RequestMapping("get_data")
	@ResponseBody
	public List<DeviceMaintain> getData(){
		return deviceMaintainService.getData();
	}

	@RequestMapping("/add_judge")
	@ResponseBody
	public void addJudge(){}
	@RequestMapping("/add")
	public String add() {
		return "deviceMaintain_add";
	}

	@RequestMapping("edit_judge")
	@ResponseBody
	public  void  editJudge(){}
	@RequestMapping("/edit")
	public String edit() {
		return "deviceMaintain_edit";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private DeviceResult insert(@Valid DeviceMaintain deviceMaintain)  {
		if(deviceMaintainService.get(deviceMaintain.getDeviceMaintainId()) != null){
			return DeviceResult.build(0, "该设备维修编号已经存在，请更换设备维修编号！", null);
		}else{
			return  deviceMaintainService.insert(deviceMaintain);
		}
	}

	@RequestMapping(value="/update")
	@ResponseBody
	private DeviceResult update(@Valid DeviceMaintain deviceMaintain)  {
		return  deviceMaintainService.update(deviceMaintain);
	}

	@RequestMapping("delete_judge")
	@ResponseBody
	public  void deleteJudge(){}
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private DeviceResult deleteBatch(String[] ids)  {
		DeviceResult result = deviceMaintainService.deleteBatch(ids);
		return result;
	}

	@RequestMapping(value="/update_note")
	@ResponseBody
	private DeviceResult updateNote(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult)
			 {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return DeviceResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceMaintainService.updateNote(deviceMaintain);
	}

	//根据设备维修编号查找
	@RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
	@ResponseBody
	public Vo searchDeviceMaintainByDeviceMaintainId(Integer page, Integer rows, String searchValue) {
		return deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(page, rows, searchValue);
	}

	//根据设备故障编号查找
	@RequestMapping("/search_deviceMaintain_by_deviceFaultId")
	@ResponseBody
	public Vo searchDeviceMaintainByDeviceFaultId(Integer page, Integer rows, String searchValue) {
		return deviceMaintainService.searchDeviceMaintainByDeviceFaultId(page, rows, searchValue);
	}
}

