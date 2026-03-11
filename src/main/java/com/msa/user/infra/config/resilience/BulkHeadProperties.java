package com.msa.user.infra.config.resilience;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "resilience4j.bulkhead")
@Getter
@Setter
public class BulkHeadProperties {

    private Map<String, Instance> instances = new HashMap<>();

    @Getter
    @Setter
    public static class Instance{
        private int maxConcurrentCalls;
        private int maxWaitDuration;
    }
}
