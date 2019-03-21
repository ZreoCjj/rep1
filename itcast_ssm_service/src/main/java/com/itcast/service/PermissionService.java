package com.itcast.service;

import com.itcast.domain.Permission;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20  17:19
 */
public interface PermissionService {

    /**
     * 分页查询所有资源权限信息
     * @param page
     * @param pageSize
     * @return
     */
    List<Permission> findAll(Integer page, Integer pageSize) throws Exception;

    /**
     * 添加资源权限
      * @param permission
     */
    void save(Permission permission)throws Exception;


    /**
     * 通过角色的id查询可以添加的权限
     * @param roleId
     * @return
     */
    List<Permission> findOtherPermission(String roleId) throws Exception;
}
