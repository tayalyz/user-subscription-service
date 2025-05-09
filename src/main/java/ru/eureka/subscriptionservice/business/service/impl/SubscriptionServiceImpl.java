package ru.eureka.subscriptionservice.business.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.eureka.subscriptionservice.business.service.SubscriptionService;
import ru.eureka.subscriptionservice.persistance.repository.SubscriptionRepository;
import ru.eureka.subscriptionservice.persistance.repository.UserRepository;
import ru.eureka.subscriptionservice.rest.dto.SubscriptionRequest;
import ru.eureka.subscriptionservice.rest.dto.SubscriptionResponse;
import ru.eureka.subscriptionservice.rest.dto.TopSubscriptionResponse;
import ru.eureka.subscriptionservice.rest.mapper.SubscriptionMapper;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final UserRepository userRepository;

    @Override
    public SubscriptionResponse addSubscription(Long userId, SubscriptionRequest request) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new EntityNotFoundException("Пользователь не найден");
        }
        var subscription = subscriptionMapper.toEntity(request);
        subscription.setUser(userRepository.findById(userId).get());
        subscriptionRepository.save(subscription);
        log.info("Создана подписка: {} для пользователя: {}", request.type(), request.userId());
        return subscriptionMapper.toResponse(subscription);
    }

    @Override
    public List<SubscriptionResponse> getUserSubscriptions(Long userId) {
        var subs = subscriptionRepository.findAllByUserId(userId);
        return subscriptionMapper.toResponseList(subs);
    }

    @Override
    public List<TopSubscriptionResponse> getTopSubscriptions() {
        return subscriptionRepository.findTopSubscriptions(PageRequest.of(0, 3));
    }

    @Override
    @Transactional
    public void deleteSubscription(Long userId, Long id) {
        subscriptionRepository.deleteByUserIdAndId(userId, id);
        log.info("Удалена подписка с id {} у пользователя с id {}", id, userId);
    }
}
