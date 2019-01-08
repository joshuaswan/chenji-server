package com.joshua.server;

import com.joshua.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by joshua on 2018-04-17.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {
    UserInfo findById(Integer id);

    UserInfo findByLoginName(String loginName);

    @Query("select u.loginName from UserInfo u ")
    List<String> getLoginName();
}
