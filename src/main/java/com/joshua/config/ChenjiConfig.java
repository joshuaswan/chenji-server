package com.joshua.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by joshua on 2018-04-17.
 * 项目个性化配置
 */
@Component
@ConfigurationProperties(prefix = "chenji")
public class ChenjiConfig {

    private Integer orderLength;

    private String orderPrefix;


    public Integer getOrderLength() {
        return orderLength;
    }

    public void setOrderLength(Integer orderLength) {
        this.orderLength = orderLength;
    }

    public String getOrderPrefix() {
        return orderPrefix;
    }

    public void setOrderPrefix(String orderPrefix) {
        this.orderPrefix = orderPrefix;
    }

    @Override
    public String toString() {
        return "ChenjiConfig{" +
                "orderLength=" + orderLength +
                ", orderPrefix='" + orderPrefix + '\'' +
                '}';
    }
}
