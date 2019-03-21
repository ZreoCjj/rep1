package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Product;
import com.itcast.exception.SysException;
import com.itcast.service.ProductService;
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
 * @date 2019/3/17
 */

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize", defaultValue = "5")
                                  Integer pageSize) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            List <Product> productList = productService.findAllByPage(page,pageSize);
            PageInfo <Product> pageInfo = new PageInfo <Product>(productList);
            mv.addObject("pageInfo",pageInfo);
            mv.setViewName("product-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有产品失败!");
        }
    }

    @RequestMapping("/save")
    public String save(Product product) throws SysException {
        try {
            productService.save(product);
            return "redirect:findAll";
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("添加产品失败!");
        }
    }




}
