package com.msa.user.infra.http.config.resilience;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResilienceType {
    //to domain / action
    ORDER_ORDER_OF_ONE_USER("ORDER_OF_ONE_USER")
    ;

    private final String resilienceType;
}
