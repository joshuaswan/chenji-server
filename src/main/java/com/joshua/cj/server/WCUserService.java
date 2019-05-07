package com.joshua.cj.server;


import com.alibaba.fastjson.JSONArray;

public interface WCUserService {
    String addWCUser(JSONArray wcUser, String openid);
}
