package com.joshua.cj.mapper;


import com.joshua.cj.pojo.OrderList;

public interface OrderListMapper {
    OrderList selectOrderListByOrderNumber(String orderNumber);
}
