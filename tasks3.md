# Tasks
# Total 194m 196m
--------------------------------------------------------------------------------------------------
[*] products                                                                              56m  45m     

1. return_201_when_POST_products_with_parameters(create product)            15m    15m

2. return_400_when_POST_fails(name,description,price are empty)              3m     3m

3. [Database test] find_product_by_productid                                10m    11m

4. return_product_when_GET_product_by_productid                              5m     2m

5. return_404_when_GET_product_by_productid_fails(productid not found)       3m     3m

6. [Database Test] find_all_products                                        10m     4m

7. return_products_when_GET_products                                        10m     7m  

--------------------------------------------------------------------------------------------------
[*] users                                                                                36m   35m               

1. return_201_when_POST_users_with_parameters(create user)                  15m    17m

2. return_400_when_POST_fails(name is empty)                                 3m     2m

3. [Database Test] find_user_by_id                                          10m     5m     

4. return_user_when_GET_user_by_id                                           5m     9m

5. return_404_when_GET_user_by_id_fails(userid not found)                    3m     2m

--------------------------------------------------------------------------------------------------
[*] orders                                                                               66m   84m    

1. return_201_when_POST_orders_with_parameters(create orders)               20m    39m

2. return_400_when_POST_fails(name,address,phone are empty)                  3m     3m

3. [Database test] find_order_by_userid_and_orderid                         15m    14m

4. return_order_when_GET_order_by_userid_and_orderid                         5m    20m

5. return_404_when_GET_order_fails(not found orderid by userid)              3m     2m

6. [Database Test] find_all_orders_by_userid                                15m     3m

7. return_orders_when_GET_orders_by_userid                                   5m     3m

--------------------------------------------------------------------------------------------------
[*] payments                                                                             36m   32m   

1. return_201_when_POST_payment_with_patameters(create payment)             15m    18m

2. return_400_when_POST_fails(amount and pay_type are empty)                 3m     2m

4. [Database Test] find_payment_by_userid_and_orderid                       10m     6m

5. return_payment_when_GET_payment_by_userid_and_orderid                     5m     4m

6. return_404_when_GET_payment_fails(not found payment by orderid)           3m     2m

--------------------------------------------------------------------------------------------------





# Database
--------------------------------------------------------------------------------------------------
1.Products
    id
    name
    description
    price
--------------------------------------------------------------------------------------------------
2.users
    id
    name
--------------------------------------------------------------------------------------------------
3.orders
    id
    name
    address
    phone
    time
    userid
--------------------------------------------------------------------------------------------------
4.orderitems
    orderid
    productid
    quantity
    amount
--------------------------------------------------------------------------------------------------
5.payments
    orderid
    paytype
    paytime
    amount
--------------------------------------------------------------------------------------------------








