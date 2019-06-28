package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
import com.cskaoyan.vo.DeviceResult;
import com.cskaoyan.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex_Cheng
 * @date 2019/6/28 10:39
 * @Description TODO
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public Vo getList(int page, int rows, DeviceType deviceType)  {
        //分页处理
        PageHelper.startPage(page, rows);
        List<Device> list = deviceTypeMapper.getList(deviceType);
        Vo result = new Vo();
        result.setRows(list);
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public DeviceType get(String string)  {
        return null;
    }

    @Override
    public List<DeviceType> getData()  {
        List<DeviceType> deviceTypeList = deviceTypeMapper.getData();
        return deviceTypeList;
    }

    @Override
    public DeviceResult insert(DeviceType deviceType)  {
        return null;
    }

    @Override
    public DeviceResult deleteBatch(String[] deviceTypeIds)  {
        return null;
    }

    @Override
    public DeviceResult update(DeviceType deviceType)  {
        return null;
    }

    @Override
    public DeviceResult updateAll(DeviceType deviceType)  {
        return null;
    }

    @Override
    public Vo searchDeviceTypeByDeviceTypeId(Integer page, Integer rows, String deviceTypeId)  {
        return null;
    }

    @Override
    public Vo searchDeviceTypeByDeviceTypeName(Integer page, Integer rows, String deviceTypeName)  {
        return null;
    }
}
