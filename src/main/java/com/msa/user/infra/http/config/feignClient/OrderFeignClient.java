package com.msa.user.infra.http.config.feignClient;

import com.msa.user.model.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//eureka
@FeignClient(
        name = "ORDER-SERVICE"
)
public interface OrderFeignClient {

    @GetMapping("/orders/{userId}")
    List<OrderResponse> readOrderOfUserUrl(@PathVariable Long userId);

}
