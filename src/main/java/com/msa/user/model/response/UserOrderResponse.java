package com.msa.user.model.response;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserOrderResponse {

    private UserResponse userResponse;
    private List<OrderResponse> orderResponses;
    private OrderFallbackResponse orderFallbackResponse;

    public static UserOrderResponse of(UserResponse userResponse, List<OrderResponse> orderResponses) {
        UserOrderResponse userOrderResponse = new UserOrderResponse();

        userOrderResponse.userResponse = userResponse;
        userOrderResponse.orderResponses = orderResponses;
        return userOrderResponse;
    }

    public static UserOrderResponse of(UserResponse userResponse, OrderFallbackResponse orderFallbackResponse) {
        UserOrderResponse userOrderResponse = new UserOrderResponse();

        userOrderResponse.userResponse = userResponse;
        userOrderResponse.orderFallbackResponse = orderFallbackResponse;
        return userOrderResponse;
    }
}
