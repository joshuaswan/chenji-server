package com.joshua.controller;

import com.joshua.entity.OrderList;
import com.joshua.entity.UserInfo;
import com.joshua.server.OrderListRepository;
import com.joshua.server.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Android���������
 * Created by joshua on 2018-04-16.
 */
@Controller
@RequestMapping(path = "/stockOut")
public class StockOutController {

    @Autowired
    public OrderListRepository orderListRepository;

    @Autowired
    public UserInfoRepository userInfoRepository;

    @GetMapping("/stockOut")
    public @ResponseBody String stockOut(@RequestParam String orderNumber,@RequestParam Integer userId,@RequestParam String to){
        OrderList orderList = orderListRepository.findByOrderNumber(orderNumber).get(0);
        UserInfo userInfo = userInfoRepository.findById(userId);
        System.out.println(orderList);
        if (orderList.getIsStock() == 2){
            return "exist";
        }else {
            orderList.setIsStock(2);
            orderList.setStockOutUser(userInfo);
            orderList.setStockOutDate(new Date());
            orderList.setOrderTo(to);
            orderListRepository.save(orderList);
            return "success";
        }
    }

    @GetMapping(path = "/search")
    public @ResponseBody OrderList search(@RequestParam String orderNumber){
        return orderListRepository.findByStockOutOrderNumber(orderNumber).get(0);
    }
}
