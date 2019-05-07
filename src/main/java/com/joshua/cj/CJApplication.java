package com.joshua.cj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@MapperScan("com.joshua.cj.mapper")
public class CJApplication {

    public static void main(String... args) {
        SpringApplication.run(CJApplication.class, args);
    }

//    @Bean
//    public WebServerFactoryCustomizer containerCustomizer(){
//
//        WebServerFactoryCustomizer webServerFactoryCustomizer = (WebServerFactoryCustomizer<ConfigurableWebServerFactory>) factory -> {
//            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
//            factory.addErrorPages(error404Page);
//        };
//        return webServerFactoryCustomizer;
//    }
}
