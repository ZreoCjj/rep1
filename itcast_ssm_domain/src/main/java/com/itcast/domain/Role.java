package com.itcast.domain;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 * 路线表
 */
public class Role {
    /**
     * 无意义，主键uuid
     */
    private String id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List <Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List <Permission> permissions) {
        this.permissions = permissions;
    }

    public List <UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List <UserInfo> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}
