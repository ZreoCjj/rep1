package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.RoleDao;
import com.itcast.domain.Role;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List <Role> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List <Role> list = roleDao.findAll();
        return list;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List <Role> findOtherRoles(String userId) {
        return roleDao.findOtherRolesByUserId(userId);
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void addPermissionToRole(String[] ids, String roleId) {
        if (ids != null && ids.length>0){
            for (String permissionId : ids) {
               roleDao.addPermissionToRole(permissionId,roleId);
            }
        }
    }
}
