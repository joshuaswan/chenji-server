package com.joshua.cj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.joshua.cj.server.WCUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cj/api/wcUser")
public class WCUserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WCUserService wcUserService;

    @RequestMapping(value = "/{openid}",produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public String addWCUser(@RequestBody JSONArray wcUser, @PathVariable String openid){
        return wcUserService.addWCUser(wcUser,openid);
    }
}
