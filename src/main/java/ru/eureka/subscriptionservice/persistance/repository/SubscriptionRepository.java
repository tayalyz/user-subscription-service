package ru.eureka.subscriptionservice.persistance.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.eureka.subscriptionservice.persistance.entity.SubscriptionEntity;
import ru.eureka.subscriptionservice.rest.dto.TopSubscriptionResponse;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

    void deleteByUserIdAndId(Long userId, Long id);

    List<SubscriptionEntity> findAllByUserId(Long userId);

    @Query("SELECT new ru.eureka.subscriptionservice.rest.dto.TopSubscriptionResponse(s.type, COUNT(s)) " +
            "FROM SubscriptionEntity s GROUP BY s.type ORDER BY COUNT(s) DESC")
    List<TopSubscriptionResponse> findTopSubscriptions(Pageable pageable);
}
