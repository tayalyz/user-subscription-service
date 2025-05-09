package ru.subscriptionservice.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.subscriptionservice.config.MapperConfiguration;
import ru.subscriptionservice.persistance.entity.SubscriptionEntity;
import ru.subscriptionservice.rest.dto.SubscriptionRequest;
import ru.subscriptionservice.rest.dto.SubscriptionResponse;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface SubscriptionMapper {

    @Mapping(target = "userId", source = "user.id")
    SubscriptionResponse toResponse(SubscriptionEntity entity);

    List<SubscriptionResponse> toResponseList(List<SubscriptionEntity> entities);

    SubscriptionEntity toEntity(SubscriptionRequest request);
}
