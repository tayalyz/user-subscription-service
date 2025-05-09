package ru.eureka.subscriptionservice.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.eureka.subscriptionservice.config.mapper.MapperConfiguration;
import ru.eureka.subscriptionservice.persistance.entity.SubscriptionEntity;
import ru.eureka.subscriptionservice.rest.dto.SubscriptionRequest;
import ru.eureka.subscriptionservice.rest.dto.SubscriptionResponse;

import java.util.List;

@Mapper(config = MapperConfiguration.class)
public interface SubscriptionMapper {

    @Mapping(target = "userId", source = "user.id")
    SubscriptionResponse toResponse(SubscriptionEntity entity);

    @Mapping(target = "type", expression="java(subscription.getType().name())")
    List<SubscriptionResponse> toResponseList(List<SubscriptionEntity> entities);



    SubscriptionEntity toEntity(SubscriptionRequest request);
}
