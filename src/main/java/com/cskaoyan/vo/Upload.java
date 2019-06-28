package com.cskaoyan.vo;

public class Upload {
    String error;
    String url;

    public Upload() {
    }

    public Upload(String error, String url) {
        this.error = error;
        this.url = url;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
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
                "error='" + error + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
