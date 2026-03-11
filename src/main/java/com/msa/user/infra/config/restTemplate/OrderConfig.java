package com.msa.user.infra.config.restTemplate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "external.order-service")
@Getter
@Setter //for injection
public class OrderConfig {
    private String baseUrl;
    private String readOrderOfUserUrl;
}
