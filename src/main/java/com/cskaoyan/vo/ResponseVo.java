package com.cskaoyan.vo;
/**
 * Created by IceFloe_Rot
 * Date 2019/6/27 Time 20:33
 */
public class ResponseVo {
    int status;
    String msg;
    String data;

    @Override
    public String toString() {
        return "ResponseVo{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ResponseVo(int status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseVo() {
    }
}
