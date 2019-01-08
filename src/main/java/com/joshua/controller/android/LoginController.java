package com.joshua.controller.android;

import com.alibaba.fastjson.JSON;
import com.joshua.entity.TokenUser;
import com.joshua.entity.UserInfo;
import com.joshua.server.TokenUserRepository;
import com.joshua.server.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by joshua on 2018-04-25.
 * Android 登陆请求控制器
 */
@Controller
@RequestMapping(path = "/android/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private TokenUserRepository tokenUserRepository;

    @PostMapping(path = "/signup")
    public @ResponseBody String loginAndroid(@RequestParam String email,@RequestParam String password){

        return "OK";
    }

    @GetMapping(path = "/logout")
    public @ResponseBody String logoutAndroid(@RequestParam String token ){
        tokenUserRepository.deleteById(token);
        return "ok";
    }

    /**
     * Android项目免登陆
     * @param token
     * @return
     */
    @GetMapping(path = "/token")
    public @ResponseBody String token(@RequestParam String token){
        List<String> tokenList = tokenUserRepository.getTokenList();
        if (tokenList.contains(token)){
            TokenUser tokenUser = tokenUserRepository.findByToken(token);
            return JSON.toJSONString(tokenUser.getUserInfo());
        }else {
            return "not in the list";
        }
    }

    /**
     * 登陆功能，并记录对应Android机器唯一表示与用户对应信息，保证登陆后不用再次输入用户名密码
     * @param loginName
     * @param password
     * @param token
     * @return
     */
    @GetMapping(path = "/signup")
    public @ResponseBody
    String loginGet(@RequestParam String loginName , @RequestParam String password ,@RequestParam String token){
        String result = null;
        List<String> userInfoList = userInfoRepository.getLoginName();
        if (userInfoList.contains(loginName)){
            System.out.println("user in the database");
            UserInfo loginUser = userInfoRepository.findByLoginName(loginName);
            if (loginUser.getPassword().equals(password)){
                TokenUser tokenUser = new TokenUser(token,loginUser);
                tokenUserRepository.save(tokenUser);
                result = JSON.toJSONString(loginUser);
            }else {
                result = "password error";
            }
        }else {
            System.out.println("user not in the database");
            result = "not exist";
        }

        return result;
    }
}
