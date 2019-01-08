package com.joshua.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by joshua on 2018-04-16.
 */

@Entity
@SequenceGenerator(name = "userInfo",sequenceName = "userInfo_sequence",initialValue = 1,allocationSize = 1)
public class UserInfo {

    @Id
    @Column(name="id")
    @GeneratedValue(generator="userInfo")
    private Integer id;

    private String phoneNumber;

    private String name;

    private String loginName;

    @ManyToOne
    private StaffType staffType;

    private String gender;

    private Date birthday;

    private String password;

    private String weChat;

    public UserInfo(Integer id, String phoneNumber, String name, String loginName, StaffType staffType, String gender, Date birthday, String password, String weChat) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.loginName = loginName;
        this.staffType = staffType;
        this.gender = gender;
        this.birthday = birthday;
        this.password = password;
        this.weChat = weChat;
    }

    public UserInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public StaffType getStaffType() {
//        return staffType;
//    }

//    public void setStaffType(StaffType staffType) {
//        this.staffType = staffType;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", staffType='" + staffType + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                ", weChat='" + weChat + '\'' +
                '}';
    }

    public StaffType getStaffType() {
        return staffType;
    }
}
