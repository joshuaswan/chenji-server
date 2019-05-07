package com.joshua.cj.server.impl;

import com.joshua.cj.mapper.OrderListMapper;
import com.joshua.cj.server.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    private OrderListMapper orderListMapper;

    @Override
    public String checkOrderNumber(String orderNumber) {
        if (orderListMapper.selectOrderListByOrderNumber(orderNumber) == null){
            return "ok";
        }else {
            return "fail";
        }
    }
}
