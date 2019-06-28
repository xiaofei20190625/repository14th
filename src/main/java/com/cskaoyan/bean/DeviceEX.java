package com.cskaoyan.bean;

/**
 * @author Alex_Cheng
 * @date 2019/6/27 20:53
 * @Description  extend device and deviceType and employe
 */
public class DeviceEX extends Device {

    private String deviceIdd;

    private String deviceTypeName;

    private String deviceKeeper;

    public DeviceEX(String deviceIdd, String deviceTypeName, String deviceKeeper) {
        this.deviceIdd = deviceIdd;
        this.deviceTypeName = deviceTypeName;
        this.deviceKeeper = deviceKeeper;
    }

    public DeviceEX() {
    }

    public String getDeviceIdd() {
        return deviceIdd;
    }

    public void setDeviceIdd(String deviceIdd) {
        this.deviceIdd = deviceIdd;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}
