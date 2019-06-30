package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.service.DeviceFaultService;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/6/29 15:03
 * @Description TODO
 */
@Controller
@RequestMapping("deviceFault")
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    //回显
    @RequestMapping("get_data")
    @ResponseBody
    public List<DeviceFault> getData(){
        List<DeviceFault> deviceFaultList = deviceFaultService.getData();
        return  deviceFaultList;
    }

    //刷新
    @RequestMapping("list")
    @ResponseBody
    public  Vo list(Integer page , Integer rows ,DeviceFault deviceFault){
        Vo list = deviceFaultService.getList(page, rows, deviceFault);
        return  list;
    }

    //编辑
    @RequestMapping("edit_judge")
    @ResponseBody
    public  void  editJudge(){}
    @RequestMapping("/edit")
    public String edit()  {
        return "deviceFault_edit";
    }


    @RequestMapping("/add")
    public String add()  {
        return "deviceFault_add";
    }
    //返回json数据为空
    @RequestMapping("/add_judge")
    @ResponseBody
    public void addJudge(){}

    @RequestMapping("update_note")
    @ResponseBody
    private DeviceResult updateNote(@Valid DeviceFault deviceFault)  {
        return deviceFaultService.updateNote(deviceFault);
    }

    @RequestMapping("insert")
    @ResponseBody
    public DeviceResult insert(@Valid DeviceFault deviceFault )  {
        if (deviceFaultService.getDeviceFaultId(deviceFault.getDeviceFaultId() ) != null) {
           return DeviceResult.build(0 ,"该故障编号已存在，请重新添加" ,null);
        } else {
            return deviceFaultService.insert(deviceFault);
        }
    }

    //更新全部
    @RequestMapping("update")
    @ResponseBody
    public  DeviceResult update(DeviceFault deviceFault){
        return deviceFaultService.update(deviceFault);
    }

    //批量刪除
    @RequestMapping("delete_judge")
    @ResponseBody
    public  void deleteJudge(){}
    @RequestMapping("delete_batch")
    @ResponseBody
    private DeviceResult deleteBatch(String[] ids)  {
        DeviceResult result = deviceFaultService.deleteBatch(ids);
        return result;
    }

    @RequestMapping("/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public Vo searchDeviceFaultByDeviceFaultId(Integer page , Integer rows , String searchValue){
        return deviceFaultService.searchDeviceFaultByDeviceFaultId(page ,rows,searchValue);
    }

    @RequestMapping("/search_deviceFault_by_deviceName")
    @ResponseBody
    public Vo searchDeviceFaultByDeviceName(Integer page,Integer rows ,String searchValue){
        return deviceFaultService.searchDeviceFaultByDeviceName(page,rows ,searchValue);
    }

    //查看
    @RequestMapping("/get/{FaultId}")
    @ResponseBody
    public DeviceFault getFaultId(@PathVariable String FaultId) {
       return deviceFaultService.getFaultId(FaultId);
    }
}
