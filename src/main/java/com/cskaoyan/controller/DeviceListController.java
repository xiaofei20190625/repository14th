package com.cskaoyan.controller;

import java.util.List;
import javax.validation.Valid;
import com.cskaoyan.bean.Device;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.service.DeviceService;
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
@RequestMapping("/deviceList")
public class DeviceListController {
    @Autowired
    private DeviceService deviceService;

    //回显设备数据
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Device> getData()  {
        return deviceService.getData();
    }

    //查找所有设备即刷新页面
    @RequestMapping("/list")
    @ResponseBody
    public Vo getList(Integer page, Integer rows, Device device)  {
        Vo result = deviceService.getList(page, rows, device);
        return result;
    }

    //根据设备编号查找设备search_device_by_deviceId
    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public Vo searchDeviceByDeviceId(Integer page, Integer rows, String searchValue)  {
        Vo result = deviceService.searchDeviceByDeviceId(page, rows, searchValue);
        return result;
    }

    //根据设备名称查找设备search_device_by_deviceName
    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public Vo searchDeviceByDeviceName(Integer page, Integer rows, String searchValue)  {
        Vo result = deviceService.searchDeviceByDeviceName(page, rows, searchValue);
        return result;
    }

    //根据设备种类名称查找设备search_device_by_deviceTypeName
    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public Vo searchDeviceByDeviceTypeName(Integer page, Integer rows, String searchValue)
             {
        Vo result = deviceService.searchDeviceByDeviceTypeName(page, rows, searchValue);
        return result;
    }

    //添加
    @RequestMapping("/add")
    public String add()  {
        return "deviceList_add";
    }
    //返回json数据为空
    @RequestMapping("/add_judge")
    @ResponseBody
    public void addJudge(){}

    //编辑
    @RequestMapping("edit_judge")
    @ResponseBody
    public void editJudge(){}
    @RequestMapping("/edit")
    public String edit()  {
        return "deviceList_edit";
    }

    //编辑后更新
    @RequestMapping(value = "/update")
    @ResponseBody
    private DeviceResult update(@Valid Device device, BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return DeviceResult.build(100, fieldError.getDefaultMessage());
        }
        return deviceService.update(device);
    }

    @RequestMapping("/get/{deviceId}")
    @ResponseBody
    public Device getItemById(@PathVariable String deviceId)  {
        Device device = deviceService.selectByPrimaryKey(deviceId);
        return device;
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    private DeviceResult insert(@Valid Device device, BindingResult bindingResult)  {
        DeviceResult result;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return DeviceResult.build(100, fieldError.getDefaultMessage());
        }
        if (deviceService.get(device.getDeviceId()) != null) {
            result = new DeviceResult(0, "该设备编号已经存在，请更换设备编号！", null);
        } else {
            result = deviceService.insert(device);
        }
        return result;
    }



    @RequestMapping(value = "/delete_batch")
    @ResponseBody
    private DeviceResult deleteBatch(String[] ids)  {
        DeviceResult result = deviceService.deleteBatch(ids);
        return result;
    }

    @RequestMapping(value = "/update_note")
    @ResponseBody
    private DeviceResult updateNote(@Valid Device device, BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return DeviceResult.build(100, fieldError.getDefaultMessage());
        }
        return deviceService.updateNote(device);
    }

    @RequestMapping(value = "/update_all")
    @ResponseBody
    private DeviceResult updateAll(@Valid Device device, BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return DeviceResult.build(100, fieldError.getDefaultMessage());
        }
        return deviceService.updateAll(device);
    }

}
