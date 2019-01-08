package com.joshua;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;

/**
 * Created by joshua on 2018/4/9.
 */
public class EncryptPassword {


    @Test
    public void encryptPassword(){
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("joshua");
        String encrypted = encryptor.encrypt("password");
        System.out.println(encrypted);
    }
}
