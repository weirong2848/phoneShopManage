package com.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class IClientConfig {
//
//    @Bean
//    @LoadBalanced
//    public DefaultClientConfigImpl iClientConfig(){
//        return new DefaultClientConfigImpl();
//    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}