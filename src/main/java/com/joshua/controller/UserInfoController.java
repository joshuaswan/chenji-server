package com.joshua.controller;

import com.joshua.entity.UserInfo;
import com.joshua.server.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息增删改控制器
 * Created by joshua on 2018-04-18.
 */
@Controller
@RequestMapping(path = "api/userInfo")
public class UserInfoController {

    private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<UserInfo> getAllUserInfo(){
        return userInfoRepository.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addGoodsType(@RequestBody UserInfo userInfo){
        System.out.println(userInfo.getStaffType());
        userInfoRepository.save(userInfo);
        return "OK";
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteGoodsType(@RequestParam Integer id){
        UserInfo userInfo = userInfoRepository.findById(id);
        userInfoRepository.delete(userInfo);
        return "OK";
    }

}
