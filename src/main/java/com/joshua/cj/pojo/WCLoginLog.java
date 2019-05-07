package com.joshua.cj.pojo;

import java.io.Serializable;
import java.util.Date;

public class WCLoginLog implements Serializable{

    private Long id;
    private Date loginDate;
    private String sessionKey;
    private String openid;

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", loginDate=" + loginDate +
                ", sessionKey='" + sessionKey + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
