package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.Payment.Payment;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PaymentMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/28.
 */
@Path("users/{userid}/orders/{orderid}/payment")
public class PaymentApi {
    @Context
    PaymentMapper paymentMapper;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPatment(Map<String ,Object>paymentinfo, @PathParam("orderid") int orderid) {
        if (paymentinfo.get("pay_type") != null && paymentinfo.get("amount") != null) {
            paymentMapper.createPayment(paymentinfo,orderid);
            return Response.status(201).build();
        }else
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Payment find_payment_by_userid_and_orderid(@PathParam("orderid")int orderid) {
        Payment payment = paymentMapper.find_payment_by_userid_and_orderid(orderid);
        if(payment!=null)
            return payment;
        else
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

}

