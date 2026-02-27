package com.msa.user.service;

import com.msa.user.model.entity.User;
import com.msa.user.model.request.UserCreateRequest;
import com.msa.user.model.response.UserResponse;
import com.msa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse create(UserCreateRequest userCreateRequest) {
        User user = User.create(
                userCreateRequest.getLoginId(),
                userCreateRequest.getEmail(),
                userCreateRequest.getPassword(),
                userCreateRequest.getName()
        );

        userRepository.save(user);

        return UserResponse.from(user);
    }
}
