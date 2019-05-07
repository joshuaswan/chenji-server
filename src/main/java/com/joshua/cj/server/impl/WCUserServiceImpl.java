package com.joshua.cj.server.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.joshua.cj.mapper.WCUserMapper;
import com.joshua.cj.pojo.WCUser;
import com.joshua.cj.server.WCUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WCUserServiceImpl implements WCUserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WCUserMapper wcUserMapper;

    @Override
    public String addWCUser(JSONArray wcUser, String openid) {
        JSONObject json = wcUser.getJSONObject(0);
        WCUser getWCUser = wcUserMapper.selectByOpenid(openid);
        if (getWCUser == null){
            WCUser wcUserObject = new WCUser(openid,
                    json.getString("nickName"),
                    Integer.valueOf(json.getString("gender")),
                    json.getString("language"),
                    json.getString("city"),
                    json.getString("province"),
                    json.getString("country"),
                    json.getString("avatarUrl"));
            wcUserMapper.insertWCUser(wcUserObject);
            return "notStaff";
        }else {
            return JSON.toJSONString(getWCUser);
        }
    }
}
