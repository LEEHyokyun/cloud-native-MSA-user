package com.msa.user.infra.http.config.resilience;

import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.springboot3.bulkhead.autoconfigure.BulkheadProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties({CircuitBreakerProperties.class, BulkHeadProperties.class})
@RefreshScope //객체 재생성 후 바인딩 필요
@RequiredArgsConstructor
public class Resilience4jConfig {

    private final CircuitBreakerProperties circuitBreakerProperties;
    private final BulkheadProperties bulkheadProperties;

    @Bean
    public CircuitBreakerRegistry circuitBreakerCustomizedRegistry() {

        Map<String, CircuitBreakerConfig> configs = new HashMap<>();

        circuitBreakerProperties.getInstances().forEach((name, prop) -> {
            CircuitBreakerConfig config =
                    CircuitBreakerConfig.custom()
                            .slidingWindowType(prop.getSlidingWindowType())
                            .slidingWindowSize(prop.getSlidingWindowSize())
                            .failureRateThreshold(prop.getFailureRateThreshold())
                            .waitDurationInOpenState(prop.getWaitDurationInOpenState())
                            .permittedNumberOfCallsInHalfOpenState(prop.getPermittedNumberOfCallsInHalfOpenState())
                            .build();

            configs.put(name, config);
        });

        return CircuitBreakerRegistry.of(configs);
    }

    @Bean
    public BulkheadRegistry bulkheadCustomizedRegistry() {

        Map<String, BulkheadConfig> configs = new HashMap<>();

        bulkheadProperties.getInstances().forEach((name, prop) -> {
            BulkheadConfig config =
                    BulkheadConfig.custom()
                            .maxConcurrentCalls(prop.getMaxConcurrentCalls())
                            .maxWaitDuration(prop.getMaxWaitDuration())
                            .build()
                    ;
            configs.put(name, config);
        });

        return BulkheadRegistry.of(configs);
    }

//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> resilience4jBuilder() {
//        CircuitBreakerConfig circuitBreakerConfig =
//                CircuitBreakerConfig.custom()
//                        .failureRateThreshold(10) //10%의 실패율 달성할 경우 circuit breker on
//                        .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED) //실패율은 thread 호출 실패 개수 누적 방식
//                        .slidingWindowSize(5) //표본은 최초 호출 기준 5개
//                        .waitDurationInOpenState(Duration.ofMillis(1000)) //circuit breaker on 시 1초동안 유지
//                        .build()
//                ;
//
//        TimeLimiterConfig timeLimiterConfig =
//                TimeLimiterConfig.custom()
//                        .timeoutDuration(Duration.ofMillis(300)) //정상 호출을 판단하는 최대 대기시간
//                        .build()
//                ;
//
//        return factory -> factory.configure(builder -> builder
//                .circuitBreakerConfig(circuitBreakerConfig)
//                .timeLimiterConfig(timeLimiterConfig)
//                , ResilienceType.ORDER_ORDER_OF_ONE_USER.getResilienceType()
//        );
//
//        //fallback 응답은 graceful degradation : 부분적 대체 응답
//    }
//
//    @Bean
//    public Customizer<Resilience4jBulkheadProvider> resilience4jProvider(){
//        BulkheadConfig bulkheadConfig = BulkheadConfig.custom()
//                .maxConcurrentCalls(5)
//                .maxWaitDuration(Duration.ZERO)
//                .build()
//                ;
//
//        return provider -> provider.configure(builder -> builder
//                .bulkheadConfig(bulkheadConfig)
//                , ResilienceType.ORDER_ORDER_OF_ONE_USER.getResilienceType()
//        );
//    }
}
