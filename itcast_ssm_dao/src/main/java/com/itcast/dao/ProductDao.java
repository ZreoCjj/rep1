package com.itcast.dao;

import com.itcast.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/17
 */
public interface ProductDao {
    /**
     * 查询所有商品
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 添加一个商品
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime, productPrice," +
            "productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void add(Product product);

    /**
     * 根据id查询
     * @return
     */
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;
}
