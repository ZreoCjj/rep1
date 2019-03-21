package com.itcast.dao;

import com.itcast.domain.Member;
import com.itcast.domain.Orders;
import com.itcast.domain.Product;
import com.itcast.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
public interface OrdersDao {

    @Select("select * from orders")
    @Results( value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",
                    javaType = Product.class,one = @One(select = "com.itcast.dao.ProductDao.findById")),
    })
    List <Orders> findAll();


    @Select("select * from orders where id = #{id}")
    @Results(id = "OrdersMap", value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",
                    javaType = Product.class,one = @One(select = "com.itcast.dao.ProductDao.findById")),
            @Result(property = "member", javaType = Member.class, column = "memberid", one = @One
                    (select = "com.itcast.dao.MemberDao.findById", fetchType = FetchType.EAGER)),
            @Result(property = "travellers", column = "id", many = @Many
                    (select = "com.itcast.dao.TravellerDao.findTravellerByOrderId", fetchType =
                            FetchType.LAZY)),
    })
    Orders findById(String id);
}
