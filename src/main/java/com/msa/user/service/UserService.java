package com.msa.user.service;

import com.msa.user.config.order.OrderConfig;
import com.msa.user.model.entity.User;
import com.msa.user.model.request.UserCreateRequest;
import com.msa.user.model.response.OrderResponse;
import com.msa.user.model.response.UserOrderResponse;
import com.msa.user.model.response.UserResponse;
import com.msa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final OrderConfig orderConfig;

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

    public UserOrderResponse readUserOrders(Long userId) {

        String readOrderOfUserUrl = String.format(orderConfig.getReadOrderOfUserUrl(), userId);

        return UserOrderResponse.of(
                UserResponse.from(userRepository.findById(userId).orElse(null)),
                restTemplate.exchange(
                        readOrderOfUserUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<OrderResponse>>() {}
                ).getBody()
        );
    }
}
