package com.itcast.dao;

import com.itcast.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20
 */
public interface RoleDao {


    @Select("select * from role where id in (select roleId from users_role where userId = " +
            "#{userId})")
    @Results(id = "roleMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", many = @Many
                    (select = "com.itcast.dao.PermissionDao.findByRoleId", fetchType =
                            FetchType.LAZY)),
    })
    /**
     *通过用户id查询路线信息
     * @param userId
     * @return
     */
    List <Role> findRoleByUserId(String userId);

    /**
     * 查询所有角色
     *
     * @return
     */
    @Select("select * from role")
    List <Role> findAll();

    /**
     * 添加角色
     *
     * @param role
     */
    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     * 根据用户的id查询用户可以添加的角色列表
     *
     * @param userId
     * @return
     */
    @Select("select * from role where id not in ( select roleId from users_role where userId =" +
            " #{userId})")
    List <Role> findOtherRolesByUserId(String userId);

    /**
     * 根据角色id查询信息
     *
     * @param roleId
     * @return
     */
    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId);

    /**
     * 为角色添加权限
     * @param permissionId
     * @param roleId
     */
    @Insert("insert into role_permission  (permissionId , roleId)  values (#{permissionId} , #{roleId})")
    void addPermissionToRole(@Param("permissionId") String permissionId, @Param("roleId")String roleId);
}
