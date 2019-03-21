package com.itcast.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */

@Controller
public class PageJumpsComponent {

    @RequestMapping("/toProductAdd")
    public String toProductAdd(){
        System.out.println("跳转产品添加页面");
        return "product-add";
    }
    @RequestMapping("/main")
    public String toMain(){
        System.out.println("跳转首页");
        return "main";
    }
    @RequestMapping("/toUserAdd")
    public String toUserAdd(){
        System.out.println("跳转添加用户页面");
        return "user-add";
    }
    @RequestMapping("/toRoleAdd")
    public String toRoleAdd(){
        System.out.println("跳转添加角色页面");
        return "role-add";
    }
   @RequestMapping("/toPermissionAdd")
    public String toPermissionAdd(){
        System.out.println("跳转添加资源权限页面");
        return "permission-add";
    }
    @RequestMapping("/to403")
    public String to403(){
        System.out.println("跳转权限不足页面");
        return "403";
    }


}
