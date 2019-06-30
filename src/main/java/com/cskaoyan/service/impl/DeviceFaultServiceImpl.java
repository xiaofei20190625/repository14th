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
    public DeviceFault get(String string) {
        return null;
    }

    @Override
    public List<DeviceFault> getData() {
        return deviceFaultMapper.getData();
    }

    @Override
    public DeviceResult insert(DeviceFault deviceFault) {
        return null;
    }

    @Override
    public DeviceResult delete(String deviceFaultId) {
        return null;
    }

    @Override
    public DeviceResult deleteBatch(String[] deviceFaultIds) {
        return null;
    }

    @Override
    public DeviceResult update(DeviceFault deviceFault) {
        return null;
    }

    @Override
    public DeviceResult updateNote(DeviceFault deviceFault) {
        return null;
    }

    @Override
    public DeviceResult updateAll(DeviceFault deviceFault) {
        return null;
    }

    @Override
    public Vo searchDeviceFaultByDeviceFaultId(Integer page, Integer rows, String deviceFaultId) {
        return null;
    }

    @Override
    public Vo searchDeviceFaultByDeviceName(Integer page, Integer rows, String deviceName) {
        return null;
    }
}
