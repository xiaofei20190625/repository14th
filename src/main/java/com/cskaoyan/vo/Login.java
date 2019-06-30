package com.cskaoyan.vo;

public class Login {
    String msg;


    public Login() {
    }

    public Login(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Login{" +
                "msg='" + msg + '\'' +
                '}';
    }
}