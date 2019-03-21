package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.OrdersDao;
import com.itcast.domain.Orders;
import com.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    private final OrdersDao ordersDao;

    @Autowired
    public OrdersServiceImpl(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @Override
    public List<Orders> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
