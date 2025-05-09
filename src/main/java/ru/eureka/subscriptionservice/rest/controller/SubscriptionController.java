package ru.eureka.subscriptionservice.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eureka.subscriptionservice.business.service.SubscriptionService;
import ru.eureka.subscriptionservice.rest.dto.SubscriptionRequest;
import ru.eureka.subscriptionservice.rest.dto.SubscriptionResponse;
import ru.eureka.subscriptionservice.rest.dto.TopSubscriptionResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/{userId}")
    public ResponseEntity<SubscriptionResponse> addSubscription(@PathVariable Long userId, @RequestBody SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.addSubscription(userId, request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions(@PathVariable(name = "userId") Long userId) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@RequestHeader("X-User-Id") Long userId, @PathVariable Long id) {
        subscriptionService.deleteSubscription(userId, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TopSubscriptionResponse>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTopSubscriptions());
    }
}
