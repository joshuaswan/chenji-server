package com.joshua.cj.controller;


import com.alibaba.fastjson.JSONObject;
import com.joshua.cj.server.WCLoginLogService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/cj/api/wcLoginLog")
public class WCLoginLogController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WCLoginLogService wcLoginLogService;

    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String login(@RequestParam String code, HttpServletRequest httpServletRequest) {
        logger.info("ip: " + httpServletRequest.getRemoteHost() + ", code: " + code);
        return wcLoginLogService.addWCLoginLog(code);
    }
}
