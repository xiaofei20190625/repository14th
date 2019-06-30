package com.cskaoyan.controller;

import javax.validation.Valid;
import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.service.DeviceCheckService;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    private DeviceCheckService deviceCheckService;

    @RequestMapping("/list")
    @ResponseBody
    public Vo getListType(Integer page, Integer rows, DeviceCheck deviceCheck)  {
        Vo result = deviceCheckService.getList(page, rows, deviceCheck);
        return result;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public void addJudge(){}
    @RequestMapping("/add")
    public String add()  {
        return "deviceCheck_add";
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public void editJudge(){}
    @RequestMapping("/edit")
    public String edit()  {
        return "deviceCheck_edit";
    }
     
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    private DeviceResult insert(@Valid DeviceCheck deviceCheck, BindingResult bindingResult)  {
        DeviceResult result;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return DeviceResult.build(100, fieldError.getDefaultMessage());
        }
        if (deviceCheckService.get(deviceCheck.getDeviceCheckId()) != null) {
            result = new DeviceResult(0, "该设备例检编号已经存在，请更换设备例检编号！", null);
        } else {
            result = deviceCheckService.insertDeviceCheck(deviceCheck);
        }
        return result;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    private DeviceResult update(@Valid DeviceCheck deviceCheck, BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return DeviceResult.build(100, fieldError.getDefaultMessage());
        }
        return deviceCheckService.update(deviceCheck);
    }

    @RequestMapping(value = "/update_note")
    @ResponseBody
    private DeviceResult updateNote(@Valid DeviceCheck deviceCheck, BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return DeviceResult.build(100, fieldError.getDefaultMessage());
        }
        return deviceCheckService.updateNote(deviceCheck);
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public  void deleteJudge(){}
    @RequestMapping(value = "/delete_batch")
    @ResponseBody
    private DeviceResult deleteBatch(String[] ids)  {
        DeviceResult result = deviceCheckService.deleteBatch(ids);
        return result;
    }

    //例检编号
    @RequestMapping("/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public Vo searchDeviceCheckByDeviceCheckId(Integer page, Integer rows, String searchValue)
             {
        Vo result = deviceCheckService.searchDeviceCheckByDeviceCheckId(page, rows, searchValue);
        return result;
    }

    //设备名称
    @RequestMapping("/search_deviceCheck_by_deviceName")
    @ResponseBody
    public Vo searchDeviceCheckByDeviceName(Integer page, Integer rows, String searchValue)
             {
        Vo result = deviceCheckService.searchDeviceCheckByDeviceName(page, rows, searchValue);
        return result;
    }
}
