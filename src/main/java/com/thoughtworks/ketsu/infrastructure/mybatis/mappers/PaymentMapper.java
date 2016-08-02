package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.Payment.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by zyongliu on 16/7/28.
 */
public interface PaymentMapper {
    void createPayment(@Param("info") Map<String, Object> paymentinfo,@Param("orderid")int orderid);

    Payment find_payment_by_userid_and_orderid(@Param("orderid") int orderid);
}
