package ru.eureka.subscriptionservice.business.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.eureka.subscriptionservice.rest.mapper.UserMapper;
import ru.eureka.subscriptionservice.business.service.UserService;
import ru.eureka.subscriptionservice.persistance.repository.UserRepository;
import ru.eureka.subscriptionservice.rest.dto.UserRequest;
import ru.eureka.subscriptionservice.rest.dto.UserResponse;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest request) {
        var user = userRepository.save(userMapper.toEntity(request));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse getUser(Long id) {
        return userMapper.toResponse(userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Пользователь с id {} не найден", id);
                    return new EntityNotFoundException("Пользователь с id " + id + " не найден");
                });
        Optional.ofNullable(request.name())
                .ifPresent(user::setName);

        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.info("Пользователь с id {} удален", id);
    }
}
