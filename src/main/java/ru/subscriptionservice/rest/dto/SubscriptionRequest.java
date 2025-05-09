package ru.subscriptionservice.rest.dto;

import ru.subscriptionservice.persistance.entity.SubscriptionType;

public record SubscriptionRequest(Long id, SubscriptionType type, Long userId) {
}
