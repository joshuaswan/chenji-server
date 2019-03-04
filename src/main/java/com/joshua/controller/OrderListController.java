package com.joshua.controller;

import com.joshua.config.ChenjiConfig;
import com.joshua.entity.OrderList;
import com.joshua.server.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by joshua on 2018-04-17.
 * web端订单信息控制器
 */
@Controller
@RequestMapping(path = "api/orderList")
public class OrderListController {

    @Autowired
    public ChenjiConfig chenjiConfig;

    @Autowired
    public OrderListRepository orderListRepository;


    /**
     * 获取下一个订单号，对应方法有问题，以后将更改或删除
     *
     * @return
     * @throws Exception
     */
    @GetMapping(path = "nextOrderNumber")
    public @ResponseBody
    String nextOrderNumber() throws Exception {
//        Iterable<OrderList> orderListIterable = orderListRepository.findAll();
        return null;
    }

//    @PostMapping(path = "addOrder")
//    public @ResponseBody
//    String addOrder(@RequestBody OrderList orderList) {
//        orderList.setCreateDate(new Date());
//        //存储后获取ID生成对应order Number
//        orderListRepository.save(orderList);
//        Integer id = orderList.getId();
//        String stringId = id.toString();
//        while (stringId.length() < chenjiConfig.getOrderLength())
//            stringId = "0" + stringId;
//        String orderNumber = chenjiConfig.getOrderPrefix() + stringId;
//        orderList.setOrderNumber(orderNumber);
//        orderListRepository.save(orderList);
//        return "OK";
//    }

    @GetMapping(path = "getOrderList")
    public @ResponseBody
    Iterable<OrderList> getOrderList() {
        return orderListRepository.findAll();
    }

    @GetMapping(path = "getStockIn")
    public @ResponseBody
    List<OrderList> getStockIn() {
        List<OrderList> orderListOptional = null;
        try {
            orderListOptional = orderListRepository.getStockIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderListOptional;
    }

    @GetMapping(path = "getStockOut")
    public @ResponseBody
    List<OrderList> getStockOut() {
        List<OrderList> orderListOptional = null;
        try {
            orderListOptional = orderListRepository.getStockOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderListOptional;
    }
}
