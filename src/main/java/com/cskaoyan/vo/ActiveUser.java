package com.cskaoyan.vo;

public class ActiveUser {
    String username;
    String rolename;

    public ActiveUser() {
    }

    public ActiveUser(String username, String rolename) {
        this.username = username;
        this.rolename = rolename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "ActiveUser{" +
                "username='" + username + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
