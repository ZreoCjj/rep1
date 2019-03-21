package com.itcast.service;

import com.itcast.domain.Orders;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
public interface OrdersService {
    /**
     * 查询所有
     * @param page
     * @param pageSize
     * @return
     */
    List<Orders> findAll(Integer page, Integer pageSize) throws Exception;

    /**
     * 根据id查询详细信息
     * @param id
     * @return
     */
    Orders findById(String id) throws Exception;
}
