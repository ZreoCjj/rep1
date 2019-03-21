package com.itcast.dao;

import com.itcast.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈佳杰
 * @version 1.0
 * @date 2019/3/18
 */
public interface TravellerDao {
    /**
     * 知道orderid通过中间表order_traveller查询traveller数据
     * @param orderId
     * @return
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where " +
            "orderId = #{orderId})")
   List<Traveller> findTravellerByOrderId(String orderId);
}
