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
@RequestMapping(path = "/stockIn")
public class StockInController {

    @Autowired
    public ChenjiConfig chenjiConfig;

    @Autowired
    public OrderListRepository orderListRepository;

    @PostMapping(path = "/save")
    public @ResponseBody
    String saveOrder(@RequestParam String orderList){
        System.out.println(orderList);

        OrderList orderList1 = JSON.parseObject(orderList,OrderList.class);

        System.out.println("============" + orderList1.toString());
        if (orderList1.getOrderNumber() == null){
            orderList1.saveOrder();
            orderListRepository.save(orderList1);
            Integer id = orderList1.getId();
            String stringId = id.toString();
            while (stringId.length() < chenjiConfig.getOrderLength())
                stringId = "0" + stringId;
            String orderNumber = chenjiConfig.getOrderPrefix() + stringId;
            orderList1.setOrderNumber(orderNumber);
            System.out.println(orderNumber+ "++++++++++++++++");
            orderListRepository.save(orderList1);
            return orderList1.getOrderNumber();
        }else {
            return null;
        }
    }

    @PostMapping(path = "/stockIn")
    public @ResponseBody
    String stockIn(@RequestParam String orderList){
        OrderList orderList1 = JSON.parseObject(orderList,OrderList.class);
        orderList1.stockIn();
        orderListRepository.save(orderList1);
        return orderList1.getOrderNumber();
    }

    @GetMapping(path = "/unPrint")
    public @ResponseBody List<OrderList> unPrint(){
        return orderListRepository.unPrint();
    }
}
