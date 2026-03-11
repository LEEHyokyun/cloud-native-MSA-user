package com.msa.user.infra.config.resilience;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "resilience4j.circuitbreaker")
@Getter
@Setter
public class CircuitBreakerProperties {

    private Map<String, Instance> instances = new HashMap<>();

    @Getter
    @Setter
    public static class Instance{
        private SlidingWindowType slidingWindowType;
        private int slidingWindowSize;
        private int failureRateThreshold;
        private Duration waitDurationInOpenState;
        private int permittedNumberOfCallsInHalfOpenState;
    }
}
