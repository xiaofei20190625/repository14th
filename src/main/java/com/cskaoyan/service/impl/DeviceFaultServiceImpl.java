package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.mapper.DeviceFaultMapper;
import com.cskaoyan.service.DeviceFaultService;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/6/29 15:05
 * @Description TODO
 */
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper ;
    @Override
    public Vo getList(int page, int rows, DeviceFault deviceFault) {
        //分页
        PageHelper.startPage(page, rows);
        List<DeviceFault> list = deviceFaultMapper.getList(deviceFault) ;
        Vo vo = new Vo();
        vo.setRows(list);
        PageInfo<DeviceFault> deviceFaultPageInfo = new PageInfo<>(list);
        vo.setTotal(deviceFaultPageInfo.getTotal());
        return vo;
    }

    @Override
    public DeviceFault getFaultId(String string) {
        return deviceFaultMapper.selectByPrimaryKey(string);
    }

    @Override
    public List<DeviceFault> getData() {
        return deviceFaultMapper.getData();
    }

    @Override
    public DeviceResult insert(DeviceFault deviceFault) {
        int i = deviceFaultMapper.insert(deviceFault);
        if(i == 1){
            return  DeviceResult.ok();
        }else
            return DeviceResult.build(100 , "添加故障失败");
    }

    @Override
    public DeviceResult delete(String deviceFaultId) {
        return null;
    }

    @Override
    public DeviceResult deleteBatch(String[] deviceFaultIds) {
        int i = deviceFaultMapper.deleteBatch(deviceFaultIds);
        if(i == 1) {
            return  DeviceResult.ok();
        }else
            return DeviceResult.build(102 , "删除故障失败");
    }

    @Override
    public DeviceResult update(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
        if (i == 1){
            return  DeviceResult.ok();
        }else
            return DeviceResult.build(101 ,"修改故障失败");
    }

    @Override
    public DeviceResult updateNote(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateNote(deviceFault);
        if(i == 1){
            return  DeviceResult.ok();
        }else
            return  DeviceResult.build(101 , "修改故障描述失败");
    }

    @Override
    public DeviceResult updateAll(DeviceFault deviceFault) {
        return null;
    }

    @Override
    public Vo searchDeviceFaultByDeviceFaultId(Integer page, Integer rows, String deviceFaultId) {
        PageHelper.startPage(page, rows);
        List<DeviceFault> list = deviceFaultMapper.searchDeviceFaultByDeviceFaultId(deviceFaultId) ;
        Vo vo = new Vo();
        vo.setRows(list);
        PageInfo<DeviceFault> deviceFaultPageInfo = new PageInfo<>(list);
        vo.setTotal(deviceFaultPageInfo.getTotal());
        return vo;
    }

    @Override
    public Vo searchDeviceFaultByDeviceName(Integer page, Integer rows, String deviceName) {
        PageHelper.startPage(page, rows);
        List<DeviceFault> list = deviceFaultMapper.searchDeviceFaultByDeviceName(deviceName) ;
        Vo vo = new Vo();
        vo.setRows(list);
        PageInfo<DeviceFault> deviceFaultPageInfo = new PageInfo<>(list);
        vo.setTotal(deviceFaultPageInfo.getTotal());
        return vo;
    }

    @Override
    public DeviceFault getDeviceFaultId(String deviceFaultId) {
        return  deviceFaultMapper.selectByPrimaryKey(deviceFaultId);
    }


}
