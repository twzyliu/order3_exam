package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.Order.Order;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.support.DatabaseTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by zyongliu on 16/7/28.
 */
@RunWith(DatabaseTestRunner.class)
public class OrderDOTest {
    @Inject
    OrderMapper orderMapper;

    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Test
    public void find_order_by_userid_and_orderid() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Map<String, Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String, Object> orderinfo = TestHelper.orderMap(userid, productid);
        orderMapper.createOrder(orderinfo, userid);
        int orderid = TestHelper.obj2int(orderinfo.get("id"));
        Order order = orderMapper.find_order_by_userid_and_orderid(orderid);
        assertThat(order.getName(), is("order3"));
    }

    @Test
    public void find_all_orders_by_userid() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Map<String, Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String, Object> orderinfo = TestHelper.orderMap(userid, productid);
        orderMapper.createOrder(orderinfo, userid);
        List<Order> orderlist = orderMapper.find_all_orders_by_userid();
        assertThat(orderlist.get(0).getName(), is("order3"));
    }
}
