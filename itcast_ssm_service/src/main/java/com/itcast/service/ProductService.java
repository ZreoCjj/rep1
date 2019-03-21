package com.itcast.service;

import com.itcast.domain.Product;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/17
 */
public interface ProductService {
    /**
     * 查询所有产品
     * @return
     */
    List<Product> findAllByPage(Integer page,Integer pageSize) throws Exception;


    /**
     * 保存一个产品
     * @param product
     */
    void save(Product product) throws Exception;
}
