package com.itcast.domain;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 * 权限表
 */
public class Permission {
    /**
     * 无意义，主键uuid
     */
    private String id;
    /**
     * 权限名
     */
    private String permissionName;
    /**
     * 资源路径
     */
    private String url;
    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List <Role> getRoles() {
        return roles;
    }

    public void setRoles(List <Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }
}
