package com.wsousa.order.http.client.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


@Slf4j
@Configuration
public class ClientConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){ return Logger.Level.FULL;}

    @Bean(name = "client")
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            try {
                requestTemplate.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            } catch (Exception ex){
                log.error("error ", ex.getMessage());
            }
        };
    }
}
