package ru.subscriptionservice.business.service;

import ru.subscriptionservice.rest.dto.SubscriptionRequest;
import ru.subscriptionservice.rest.dto.SubscriptionResponse;
import ru.subscriptionservice.rest.dto.TopSubscriptionResponse;

import java.util.List;

public interface SubscriptionService {
    SubscriptionResponse addSubscription(Long userId, SubscriptionRequest request);

    void deleteSubscription(Long userId, Long id);

    List<SubscriptionResponse> getUserSubscriptions(Long userId);

    List<TopSubscriptionResponse> getTopSubscriptions();
}
