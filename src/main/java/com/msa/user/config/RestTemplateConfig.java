package com.msa.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced //USER-SERVICE = service Id에 해당하는 물리주소 매핑(내부)
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }
}
