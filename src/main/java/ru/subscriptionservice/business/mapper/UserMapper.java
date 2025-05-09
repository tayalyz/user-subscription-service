package ru.subscriptionservice.business.mapper;

import org.mapstruct.Mapper;
import ru.subscriptionservice.config.MapperConfiguration;
import ru.subscriptionservice.persistance.entity.UserEntity;
import ru.subscriptionservice.rest.dto.UserRequest;
import ru.subscriptionservice.rest.dto.UserResponse;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper {

    UserResponse toResponse(UserEntity entity);

    UserEntity toEntity(UserRequest request);
}
