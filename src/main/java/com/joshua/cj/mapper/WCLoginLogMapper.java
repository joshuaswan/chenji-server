package com.joshua.cj.mapper;

import java.util.Date;

public interface WCLoginLogMapper {
    void insertWCLoginLog(Date loginDate, String sessionKey, String openid);
}
