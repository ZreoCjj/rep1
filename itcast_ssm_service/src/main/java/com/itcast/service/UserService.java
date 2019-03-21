package com.itcast.service;

import com.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
public interface UserService extends UserDetailsService {
    /**
     * 保存用户
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 分页查询所有
     * @param page
     * @param pageSize
     * @return
     */
    List<UserInfo> findAll(int page,int pageSize) throws Exception;

    /**
     * 依据id查询详细信息
     * @param id
     * @return
     */
    UserInfo findById(String id) throws Exception;


    /**
     * 用户添加角色,操作users_role表
     * @param ids
     * @param id
     */
    void addRoleToUser(String[] ids, String id) throws Exception;
}
