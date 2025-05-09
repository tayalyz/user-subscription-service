package ru.subscriptionservice.rest.dto;

import ru.subscriptionservice.persistance.entity.SubscriptionType;

public record TopSubscriptionResponse(SubscriptionType type, Long count) {
}
