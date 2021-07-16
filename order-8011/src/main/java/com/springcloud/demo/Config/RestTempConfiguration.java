package com.springcloud.demo.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempConfiguration {

    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
