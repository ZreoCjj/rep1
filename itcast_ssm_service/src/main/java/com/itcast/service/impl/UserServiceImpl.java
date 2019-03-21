package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.UserDao;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 登陆功能
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        User user = null;
        try {
            userInfo = userDao.findByUsername(username);
            //处理自己的用户对象封装成UserDetails
            user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo
                    .getStatus() == 1, true, true, true, getAuthority(userInfo.getRoles()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 添加用户
     *
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    /**
     * 查询所有用户,不包括role信息
     *
     * @return
     */
    @Override
    public List <UserInfo> findAll(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return userDao.findAll();
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String[] ids, String userId) {
        if (ids==null||ids.length==0){
            return;
        }
        for (String roleId : ids) {
            userDao.addRoleToUser(roleId,userId);
        }

    }

    /**
     * 作用就是返回一个List集合，集合中装入的是角色描述
     */
    private List <SimpleGrantedAuthority> getAuthority(List <Role> roles) {

        List <SimpleGrantedAuthority> list = new ArrayList <>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
