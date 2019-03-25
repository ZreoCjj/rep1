package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.exception.SysException;
import com.itcast.service.RoleService;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping("/save")
    @Secured("ROLE_USER")
    public String save(UserInfo userInfo) throws SysException {
        try {
            userService.save(userInfo);
            return "redirect:findAll";
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("保存用户失败,用户名被占用!");
        }
    }

    @RequestMapping("/findAll")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_VIP')")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", defaultValue = "5")
                                        Integer pageSize) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            List <UserInfo> list = userService.findAll(page, pageSize);
            PageInfo <UserInfo> pageInfo = new PageInfo <>(list);
            mv.addObject("pageInfo", pageInfo);
            mv.setViewName("user-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户失败!");
        }
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            UserInfo user = userService.findById(id);
            mv.addObject("user", user);
            mv.setViewName("user-show");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询用户详情失败!");
        }
    }

    @RequestMapping("/findUserByIdAndAllRole")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView findUserByIdAndAllRole(String id) throws SysException {
        try {
            UserInfo user = userService.findById(id);
            List <Role> roleList = roleService.findOtherRoles(id);
            ModelAndView mv = new ModelAndView();
            mv.addObject("user", user);
            mv.addObject("roleList", roleList);
            mv.setViewName("user-role-add");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询用户可添加角色失败!");
        }

    }

    @RequestMapping(value = "/addRoleToUser", method = RequestMethod.POST)
    public String addRoleToUser(@RequestParam("ids") String[] ids, String userId)
            throws SysException {
        try {
            userService.addRoleToUser(ids, userId);
            return "redirect:findAll";
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("添加角色失败!");
        }

    }
}
