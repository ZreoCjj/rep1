package com.itcast.dao;

import com.itcast.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20
 */
public interface PermissionDao {

    /**
     * 根据角色id查询权限集合,多对多关系
     * @param roleId
     * @return
     */
    @Select("select * from Permission where id in (select permissionId from role_permission where roleId = " +
            "#{roleId} )")
    List<Permission> findByRoleId(String roleId);


    /**
     * 查询所有权限
     * @return
     */
    @Select("select * from Permission")
    List<Permission> findAll();


    /**
     * 添加权限
     * @param permission
     */
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission);

    /**
     * 通过角色的id查询还没有添加的权限
     * @param roleId
     * @return
     */
    @Select("select * from Permission where id not in ( select PermissionId from role_permission where roleId =" +
            " #{roleId})")
    List<Permission> findOtherPermission(String roleId);
}
