package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Permission;
import com.itcast.domain.Product;
import com.itcast.exception.SysException;
import com.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/20
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize", defaultValue = "5")
                                  Integer pageSize) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            List<Permission> list = permissionService.findAll(page,pageSize);
            PageInfo<Permission> pageInfo = new PageInfo <Permission>(list);
            mv.addObject("pageInfo",pageInfo);
            mv.setViewName("permission-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有资源权限失败!");
        }
    }

    @RequestMapping("/save")
    public String save(Permission permission) throws SysException{
        try {
            permissionService.save(permission);
            return "redirect:findAll";
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("添加资源权限失败!");
        }

    }


}
