package com.joshua.cj.mapper;

import com.joshua.cj.pojo.WCUser;

import java.util.Date;

public interface WCUserMapper {
    void insertWCUser(WCUser wcUser);
    WCUser selectByOpenid(String openid);
    void addLoginCount(String openid, Date lastLogin);
}
