package com.msa.user.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class OrderResponse {
    private Long orderId;
    private Long userId;
    @JsonIgnore
    private String orderStatus;
    @JsonIgnore
    private LocalDateTime orderDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
