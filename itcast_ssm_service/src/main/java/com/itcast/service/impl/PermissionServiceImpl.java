package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.PermissionDao;
import com.itcast.domain.Permission;
import com.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019-03-20 17:22
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;


    @Override
    public List<Permission> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Permission> list = permissionDao.findAll();
        return list;
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List <Permission> findOtherPermission(String roleId) {

        return permissionDao.findOtherPermission(roleId);
    }
}
