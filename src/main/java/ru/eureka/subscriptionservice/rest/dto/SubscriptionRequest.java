package ru.eureka.subscriptionservice.rest.dto;

import ru.eureka.subscriptionservice.persistance.entity.SubscriptionType;

public record SubscriptionRequest(Long id, SubscriptionType type, Long userId) {
}
