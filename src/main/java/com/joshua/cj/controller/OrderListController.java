package com.joshua.cj.controller;

import com.joshua.cj.server.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cj/api/orderList")
public class OrderListController {

    @Autowired
    OrderListService orderListService;
    @RequestMapping(value = "/checkOrderNumber/{orderNumber}", produces = "application/json;charset=UTF-8")
    public String login(@PathVariable String orderNumber, HttpServletRequest httpServletRequest) {
        return orderListService.checkOrderNumber(orderNumber);
    }
}
