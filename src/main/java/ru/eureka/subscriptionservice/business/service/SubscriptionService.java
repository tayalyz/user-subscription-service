package ru.eureka.subscriptionservice.business.service;

import ru.eureka.subscriptionservice.rest.dto.SubscriptionRequest;
import ru.eureka.subscriptionservice.rest.dto.SubscriptionResponse;
import ru.eureka.subscriptionservice.rest.dto.TopSubscriptionResponse;

import java.util.List;

public interface SubscriptionService {
    SubscriptionResponse addSubscription(Long userId, SubscriptionRequest request);

    void deleteSubscription(Long userId, Long id);

    List<SubscriptionResponse> getUserSubscriptions(Long userId);

    List<TopSubscriptionResponse> getTopSubscriptions();
}
