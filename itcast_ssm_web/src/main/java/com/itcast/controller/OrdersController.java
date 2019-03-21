package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Orders;
import com.itcast.exception.SysException;
import com.itcast.service.OrdersService;
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
 * @date 2019/3/18
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "pageSize", defaultValue = "5")
                                  Integer pageSize) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            List<Orders> list = ordersService.findAll(page,pageSize);
            PageInfo <Orders> pageInfo = new PageInfo <Orders>(list);
            mv.addObject("pageInfo",pageInfo);
            mv.setViewName("orders-list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有订单出错!");
        }
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id ) throws SysException {
        try {
            ModelAndView mv = new ModelAndView();
            Orders order = ordersService.findById(id);
            mv.addObject("orders",order);
            mv.setViewName("orders-show");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询订单详情出错!");
        }

    }
}
