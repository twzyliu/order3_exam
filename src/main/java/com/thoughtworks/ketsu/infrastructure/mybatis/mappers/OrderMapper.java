package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.Order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/28.
 */
public interface OrderMapper {
    void createOrder(@Param("info") Map<String, Object> orderinfo, @Param("userid") int userid);

    Order find_order_by_userid_and_orderid(@Param("id") int orderid);

    List<Order> find_all_orders_by_userid();
}
