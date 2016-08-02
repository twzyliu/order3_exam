package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.Payment.Payment;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PaymentMapper;
import com.thoughtworks.ketsu.infrastructure.repositories.ProductRepository;
import com.thoughtworks.ketsu.infrastructure.repositories.UserRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zyongliu on 16/7/28.
 */
@RunWith(ApiTestRunner.class)
public class PaymentApiTest extends ApiSupport{
    @Inject
    OrderMapper orderMapper;

    @Inject
    UserRepository userRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    PaymentMapper paymentMapper;

    @Test
    public void return_201_when_POST_payment_with_patameters() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Map<String,Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String,Object> orderinfo = TestHelper.orderMap(userid,productid);
        orderMapper.createOrder(orderinfo,userid);
        int orderid = TestHelper.obj2int(orderinfo.get("id"));
        Response post = post("/users/"+userid+"/orders/"+orderid+"/payment", TestHelper.paymentMap());
        assertThat(post.getStatus(),is(201));
    }

    @Test
    public void return_400_when_POST_fails() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Map<String,Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String,Object> orderinfo = TestHelper.orderMap(userid,productid);
        orderMapper.createOrder(orderinfo,userid);
        int orderid = TestHelper.obj2int(orderinfo.get("id"));
        Response post = post("/users/"+userid+"/orders/"+orderid+"/payment", TestHelper.paymentfailMap());
        assertThat(post.getStatus(),is(400));
    }

    @Test
    public void return_payment_when_GET_payment_by_userid_and_orderid() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Map<String,Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String,Object> orderinfo = TestHelper.orderMap(userid,productid);
        orderMapper.createOrder(orderinfo,userid);
        int orderid = TestHelper.obj2int(orderinfo.get("id"));
        paymentMapper.createPayment(TestHelper.paymentMap(), orderid);
        Response get = get("/users/" + userid + "/orders/" + orderid + "/payment");
        Map payment = get.readEntity(Map.class);
        assertThat(payment.get("pay_type"),is("CASH"));
    }

    @Test
    public void return_404_when_GET_payment_fails() {
        Map<String, Object> userinfo = TestHelper.userMap();
        userRepository.createUser(userinfo);
        int userid = TestHelper.obj2int(userinfo.get("id"));
        Map<String,Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Map<String,Object> orderinfo = TestHelper.orderMap(userid,productid);
        orderMapper.createOrder(orderinfo,userid);
        int orderid = TestHelper.obj2int(orderinfo.get("id"));
        Response get = get("/users/" + userid + "/orders/" + orderid + "/payment");
        assertThat(get.getStatus(),is(404));
    }
}
