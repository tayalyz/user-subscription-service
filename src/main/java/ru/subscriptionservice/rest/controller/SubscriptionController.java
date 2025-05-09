package ru.subscriptionservice.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.subscriptionservice.business.service.SubscriptionService;
import ru.subscriptionservice.rest.dto.SubscriptionRequest;
import ru.subscriptionservice.rest.dto.SubscriptionResponse;
import ru.subscriptionservice.rest.dto.TopSubscriptionResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<SubscriptionResponse> addSubscription(@RequestHeader("X-User-Id") Long userId, @RequestBody SubscriptionRequest request) {
        return ResponseEntity.ok(subscriptionService.addSubscription(userId, request));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions(@RequestHeader("X-User-Id") Long userId) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@RequestHeader("X-User-Id") Long userId, @PathVariable Long id) {
        subscriptionService.deleteSubscription(userId, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<TopSubscriptionResponse>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTopSubscriptions());
    }
}
