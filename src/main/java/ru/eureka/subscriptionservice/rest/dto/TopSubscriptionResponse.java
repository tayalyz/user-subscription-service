package ru.eureka.subscriptionservice.rest.dto;

import ru.eureka.subscriptionservice.persistance.entity.SubscriptionType;

public record TopSubscriptionResponse(SubscriptionType type, Long count) {
}
