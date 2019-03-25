package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Permission;
import com.itcast.domain.Role;
import com.itcast.exception.SysException;
import com.itcast.service.PermissionService;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Autowired
    public RoleController(RoleService roleService, PermissionService permissionService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize", defaultValue = "5")
                                  Integer pageSize) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            List <Role> list = roleService.findAll(page, pageSize);
            PageInfo <Role> pageInfo = new PageInfo <Role>(list);
            mv.addObject("pageInfo", pageInfo);
            mv.setViewName("role-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有角色失败!");
        }
    }

    @RequestMapping("/save")
    public String save(Role role) throws SysException {
        try {
            roleService.save(role);
            return "redirect:findAll";
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("添加角色失败!");
        }
    }

    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam("id") String roleId) throws
            SysException {
        try {
            Role role = roleService.findById(roleId);
            List<Permission> permissionList = permissionService.findOtherPermission(roleId);
            ModelAndView mv = new ModelAndView();
            mv.addObject("role",role);
            mv.addObject("permissionList",permissionList);
            mv.setViewName("role-permission-add");
            return mv;

        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询角色可添加权限失败!");
        }

    }

    @RequestMapping(value = "/addPermissionToRole",method = RequestMethod.POST)
    public String addPermissionToRole(@RequestParam("ids") String[] ids, String roleId)
            throws SysException {
        try {
            roleService.addPermissionToRole(ids,roleId);
            return "redirect:findAll";
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("添加权限失败!");
        }

    }

}
