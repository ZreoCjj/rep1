package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.domain.Product;
import com.itcast.dao.ProductDao;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/17
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAllByPage(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.add(product);
    }
}
