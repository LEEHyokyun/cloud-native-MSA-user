package com.msa.user.service;

import com.msa.user.infra.http.config.feignClient.OrderFeignClient;
import com.msa.user.model.entity.User;
import com.msa.user.model.request.UserCreateRequest;
import com.msa.user.model.response.OrderFallbackResponse;
import com.msa.user.model.response.UserOrderResponse;
import com.msa.user.model.response.UserResponse;
import com.msa.user.repository.UserRepository;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OrderFeignClient orderFeignClient;

    private final String ORDER_OF_ONE_USER_FALLBACK_ID = "ORDER_OF_ONE_USER";

    @Transactional
    public UserResponse create(UserCreateRequest userCreateRequest) {
        User user = User.create(
                userCreateRequest.getEmail(),
                userCreateRequest.getLoginId(),
                userCreateRequest.getPassword(),
                userCreateRequest.getName()
        );

        userRepository.save(user);

        return UserResponse.from(user);
    }

    public UserResponse readUser(Long userId) {
        return UserResponse.from(userRepository.findById(userId).orElse(null));
    }

    public List<UserResponse> readAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::from)//Entity > Dto
                .toList();
    }

    @Bulkhead(name = ORDER_OF_ONE_USER_FALLBACK_ID, type = Bulkhead.Type.SEMAPHORE)
    @CircuitBreaker(name = ORDER_OF_ONE_USER_FALLBACK_ID, fallbackMethod = "readUserOrders")
    public UserOrderResponse readUserOrders(Long userId) {

//        String readOrderOfUserUrl = String.format(orderConfig.getReadOrderOfUserUrl(), userId);
//
//        return UserOrderResponse.of(
//                UserResponse.from(userRepository.findById(userId).orElse(null)),
//                restTemplate.exchange(
//                        readOrderOfUserUrl,
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<OrderResponse>>() {}
//                ).getBody()
//        );

        return UserOrderResponse.of(
        UserResponse.from(userRepository.findById(userId).orElse(null)),
        orderFeignClient.readOrderOfUserUrl(userId)
            );
    }

    private UserOrderResponse readUserOrders(Long userId, Throwable throwable) {
        return UserOrderResponse.of(
                UserResponse.from(userRepository.findById(userId).orElse(null)),
                OrderFallbackResponse.from("[ERROR]+"+"["+throwable+"]주문 내역을 불러올 수 없습니다.")
        );
    }
}
