package com.cskaoyan.service;

import com.cskaoyan.bean.Device;
import com.cskaoyan.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface DeviceService {
    Device queryDeviceById(String id);


}
