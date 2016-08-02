package com.thoughtworks.ketsu.domain.Order;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/28.
 */
public class Order implements Record{
    private int id;
    private String name;
    private String address;
    private String phone;
    private int ordertime;
    private List<OrderItem> orderItems;
    private int userid;

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap<String, Object>() {{
            put("uri", "orders/"+id);
            put("name", name);
            put("address", address);
            put("phone", phone);
            put("creat_at", ordertime);
            put("total_price", getTotalPrice());
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        List<Map<String, Object>> Itemlist = new ArrayList<Map<String, Object>>();
        Map<String, Object> torefjson = toRefJson(routes);
        for (OrderItem tmp : orderItems) {
            Itemlist.add(tmp.toJson(routes));
        }
        torefjson.put("orderItems", Itemlist);
        return torefjson;
    }

    private double getTotalPrice() {
        double totalprice = 0;
        for (OrderItem tmp : orderItems) {
            totalprice += tmp.getAmount();
        }
        return totalprice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
