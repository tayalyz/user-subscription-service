package ru.eureka.subscriptionservice.rest.mapper;

import org.mapstruct.Mapper;
import ru.eureka.subscriptionservice.config.MapperConfiguration;
import ru.eureka.subscriptionservice.persistance.entity.UserEntity;
import ru.eureka.subscriptionservice.rest.dto.UserRequest;
import ru.eureka.subscriptionservice.rest.dto.UserResponse;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper {

    UserResponse toResponse(UserEntity entity);

    UserEntity toEntity(UserRequest request);
}
