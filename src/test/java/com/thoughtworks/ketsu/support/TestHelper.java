package com.thoughtworks.ketsu.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHelper {

    public static Map<String, Object> userMap() {
        return new HashMap<String, Object>() {{
            put("name", "zyl");
        }};
    }
    public static Map<String, Object> userfailMap() {
        return new HashMap<String, Object>() {{
        }};
    }

    public static Map<String, Object> productMap() {
        return new HashMap<String, Object>() {{
            put("name", "food");
            put("description", "good");
            put("price", 10);
        }};
    }

    public static Map<String, Object> productfailMap() {
        return new HashMap<String, Object>() {{
            put("name", "food");
            put("price", 10);
        }};
    }

    public static Map<String, Object> orderMap(int userid,int productid) {
        return new HashMap<String, Object>() {{
            put("name", "order3");
            put("address", "beijing");
            put("phone", "12345678901");
            put("userid", userid);
            put("order_items", orderItemMap(productid));
        }};
    }
    public static Map<String, Object> orderfailMap(int userid,int productid) {
        return new HashMap<String, Object>() {{
            put("name", "food");
            put("phone", "12345678901");
            put("userid", userid);
            put("orderItems", orderItemMap(productid));
        }};
    }

    public static List<Map<String, Object>> orderItemMap(int productid) {
        List<Map<String, Object>> Itemlist = new ArrayList<Map<String, Object>>();
        Map<String,Object> orderItem = new HashMap<String, Object>() {{
            put("quantity", 2);
            put("product_id", productid);
        }};
        Itemlist.add(orderItem);
        return Itemlist;
    }

    public static Map<String, Object> paymentMap() {
        return new HashMap<String, Object>() {{
            put("pay_type", "CASH");
            put("amount", 1000);
        }};
    }
    public static Map<String, Object> paymentfailMap() {
        return new HashMap<String, Object>() {{
            put("pay_type", "CASH");
        }};
    }

    public static int obj2int(Object object) {
        return Integer.valueOf(String.valueOf(object));
    }
}
