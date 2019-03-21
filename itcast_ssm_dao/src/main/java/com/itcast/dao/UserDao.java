package com.itcast.dao;

import com.itcast.domain.Product;
import com.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Select("select * from users where  username = #{username}")
    @Results(id = "userMap", value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles", column = "id", many = @Many
                    (select = "com.itcast.dao.RoleDao.findRoleByUserId", fetchType =
                            FetchType.LAZY)),
    })
    UserInfo findByUsername(String username);

    /**
     * 添加用户
     * @param userInfo
     */
    @Insert("insert into users (email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    /**
     * 查询所有
     */
    @Select("select * from users")
    List<UserInfo> findAll();


    @Select("select * from users where  id = #{id}")
    @Results(id = "UserMap", value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles", column = "id", many = @Many
                    (select = "com.itcast.dao.RoleDao.findRoleByUserId", fetchType =
                            FetchType.LAZY)),
    })
    /**
     * 通过user的id查询用户的详细信息
     */
    UserInfo findById(String id);

    /**
     * 操作users_role表,添加记录
     * @param roleId
     * @param userId
     */
    @Insert("insert into users_role (roleId , userId) values (#{roleId} , #{userId})")
    void addRoleToUser(@Param("roleId") String roleId, @Param("userId") String userId);
}
