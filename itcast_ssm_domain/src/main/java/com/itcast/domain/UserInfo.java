package com.itcast.domain;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 * 用户表
 */
public class UserInfo {
    /**
     * 无意义，主键uuid
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 邮箱,非空，唯一
     */
    private String email;
    /**
     * 密码（加密）
     */
    private String password;
    /**
     * 电话
     */
    private String phoneNum;
    /**
     * 状态0 未开启 1 开启
     */
    private int status;
    /**
     * 状态0 未开启 1 开启,字符串
     */
    private String statusStr;
    private List <Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 状态0 未开启 1 开启,字符串
     */
    public String getStatusStr() {
        if (status == 0) {
            return "未开启";
        }
        if (status == 1) {
            return "开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List <Role> getRoles() {
        return roles;
    }

    public void setRoles(List <Role> roles) {
        this.roles = roles;
    }
}
