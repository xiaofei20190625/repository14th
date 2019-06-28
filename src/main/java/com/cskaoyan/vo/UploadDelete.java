package com.cskaoyan.vo;

public class UploadDelete {
    String data;

    public UploadDelete() {
    }

    public UploadDelete(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UploadDelete{" +
                "data='" + data + '\'' +
                '}';
    }
}
