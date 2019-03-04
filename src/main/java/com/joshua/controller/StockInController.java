package com.joshua.controller;

import com.alibaba.fastjson.JSON;
import com.joshua.config.ChenjiConfig;
import com.joshua.entity.OrderList;
import com.joshua.server.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Android入库控制器
 * Created by joshua on 2018-04-16.
 */
@Controller
@RequestMapping(path = "api/stockIn")
public class StockInController {

    @Autowired
    public ChenjiConfig chenjiConfig;

    @Autowired
    public OrderListRepository orderListRepository;

    @PostMapping(path = "/save")
    public @ResponseBody
    String saveOrder(@RequestBody OrderList orderList) {
        System.out.println(orderList);

        System.out.println("============" + orderList.toString());
        if (orderList.getOrderNumber() == null) {
            orderList.stockIn();
            orderListRepository.save(orderList);
            Integer id = orderList.getId();
            String stringId = id.toString();
            while (stringId.length() < chenjiConfig.getOrderLength())
                stringId = "0" + stringId;
            String orderNumber = chenjiConfig.getOrderPrefix() + stringId;
            orderList.setOrderNumber(orderNumber);
            System.out.println(orderNumber + "++++++++++++++++");
            orderListRepository.save(orderList);
            return orderList.getOrderNumber();
        } else {
            return null;
        }
    }

    @PostMapping(path = "/stockIn")
    public @ResponseBody
    String stockIn(@RequestBody String orderList) {
        OrderList orderList1 = JSON.parseObject(orderList, OrderList.class);
        orderList1.stockIn();
        orderListRepository.save(orderList1);
        return orderList1.getOrderNumber();
    }

    @GetMapping(path = "/unPrint")
    public @ResponseBody
    List<OrderList> unPrint() {
        return orderListRepository.unPrint();
    }
}
