package com.joshua.cj.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.joshua.cj.mapper.WCLoginLogMapper;
import com.joshua.cj.mapper.WCUserMapper;
import com.joshua.cj.server.WCLoginLogService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;

@Service
@Transactional
public class WCLoginLogServiceImpl implements WCLoginLogService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WCLoginLogMapper wcLoginLogMapper;

    @Autowired
    private WCUserMapper wcUserMapper;
    @Value("${cj.app-id}")
    private String appId;

    @Value("${cj.app-secret}")
    private String appSecret;

    @Override
    public String addWCLoginLog(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + appSecret +
                "&js_code=" + code + "&grant_type=authorization_code";
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String sessionKey = null;
        String openid = null;
        String result = null;
        try {
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
            try {
                HttpEntity httpEntity = closeableHttpResponse.getEntity();
                result = EntityUtils.toString(httpEntity);
                logger.info(result);
                sessionKey = JSONObject.parseObject(result).getString("session_key");
                openid = JSONObject.parseObject(result).getString("openid");
            } finally {
                closeableHttpResponse.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wcUserMapper.selectByOpenid(openid) == null){
            wcLoginLogMapper.insertWCLoginLog(new Date(),sessionKey,openid);
            logger.info(openid + "：该用户未授权");
        }else {
            wcLoginLogMapper.insertWCLoginLog(new Date(),sessionKey,openid);
            wcUserMapper.addLoginCount(openid,new Date());
        }
        return openid;
    }
}
