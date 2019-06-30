package com.cskaoyan.vo;

public class Upload {
    int error;
    String url;

    public Upload() {
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "error=" + error +
                ", url='" + url + '\'' +
                '}';
    }
}
