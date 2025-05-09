package ru.eureka.subscriptionservice.business.service;

import ru.eureka.subscriptionservice.rest.dto.UserRequest;
import ru.eureka.subscriptionservice.rest.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse getUser(Long id);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}
