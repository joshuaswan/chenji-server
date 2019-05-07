package com.joshua.cj.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cj/api")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${cj.name}")
    private String name;

    @RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
    public String getIndexData(HttpServletRequest httpServletRequest) {
        logger.info("IP: " + httpServletRequest.getRemoteHost());
        return "欢迎来到陈记海参管理系统！" + name;
    }

}
