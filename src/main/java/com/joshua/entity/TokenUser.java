package com.joshua.entity;

import javax.persistence.*;

/**
 * Created by joshua on 2018-05-05.
 */
@Entity
@SequenceGenerator(name = "tokenUser",sequenceName = "tokenUser_sequence",initialValue = 1,allocationSize = 1)

public class TokenUser {

    @Id
    private String token;

    @ManyToOne
    private UserInfo userInfo;

    public TokenUser(String token, UserInfo userInfo) {
        this.token = token;
        this.userInfo = userInfo;
    }

    public TokenUser() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
