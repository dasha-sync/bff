package api.controller;

import api.dto.common.ApiResponse;
import api.dto.subscription.SubscriptionResponse;
import api.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
  private final SubscriptionService subscriptionService;

  @PostMapping("/create/{cardId}")
  public ResponseEntity<ApiResponse<SubscriptionResponse>> createSubscription(
      @PathVariable Long cardId) throws Exception {
    SubscriptionResponse subscription = subscriptionService.createSubscription(cardId);
    return ResponseEntity.ok(new ApiResponse<>("Subscription created successfully", subscription));
  }

  @DeleteMapping("/cancel")
  public ResponseEntity<ApiResponse<SubscriptionResponse>> cancelSubscription() throws Exception {
    subscriptionService.cancelSubscription();
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/change-payment-method/{cardId}")
  public ResponseEntity<ApiResponse<SubscriptionResponse>> updatePaymentMethod(
      @PathVariable Long cardId) throws Exception {
    subscriptionService.updatePaymentMethod(cardId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<ApiResponse<SubscriptionResponse>> getSubscription() {
    SubscriptionResponse subscription = subscriptionService.getSubscription();
    return ResponseEntity.ok(new ApiResponse<>("User subscription", subscription));
  }
}
