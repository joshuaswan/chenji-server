package com.joshua.server;

import com.joshua.entity.TokenUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by joshua on 2018-05-05.
 */
public interface TokenUserRepository  extends CrudRepository<TokenUser,Long> {

    @Query("select t from TokenUser t")
    List<TokenUser> getTokenUser();


    @Query("select t.token from TokenUser t")
    List<String> getTokenList();

    TokenUser findByToken(String token);

    @Transactional
    @Modifying
    @Query(value = "delete from TokenUser t where t.token = :token")
    void deleteById(@Param("token")String token);
}
