package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alex_Cheng
 * @date 2019/6/26 16:51
 * @Description TODO
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Resource
    @Autowired
    DeviceMapper deviceMapper ;

    @Override
    public Device queryDeviceById(String id) {
        Device device = deviceMapper.selectByPrimaryKey(id);
        return device;

    }
}
