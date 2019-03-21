package com.itcast.service;

import com.itcast.domain.Role;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20
 */
public interface RoleService {
    /**
     * 查询所有角色
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<Role> findAll(Integer page, Integer pageSize) throws Exception;

    /**
     * 添加角色
     * @param role
     */
    void save(Role role)throws Exception;

    /**
     * 根据用户id查询可以添加的角色列表
     * @param userId
     * @return
     */
    List<Role> findOtherRoles(String userId) throws Exception;


    /**
     * 根据角色id查询详细信息,包括permission信息
     * @param roleId
     * @return
     */
    Role findById(String roleId) throws Exception;


    /**
     * 添加权限
     * @param ids
     * @param roleId
     */
    void addPermissionToRole(String[] ids, String roleId) throws Exception;
}
