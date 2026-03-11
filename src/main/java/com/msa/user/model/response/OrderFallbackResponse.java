package com.msa.user.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class OrderFallbackResponse {
    private String fallbackMessage;

    public static OrderFallbackResponse from(String fallbackMessage) {
        OrderFallbackResponse orderFallbackResponse = new OrderFallbackResponse();

        orderFallbackResponse.fallbackMessage = fallbackMessage;
        return orderFallbackResponse;
    }
}
