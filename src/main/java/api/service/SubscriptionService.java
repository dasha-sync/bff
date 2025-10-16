package api.service;

import api.client.RegistryClient;
import api.dto.subscription.SubscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
  private final RegistryClient registryClient;

  public SubscriptionResponse createSubscription(Long cardId) throws Exception {
    return registryClient.post("/subscription/create/" + cardId, cardId, SubscriptionResponse.class);
  }

  public void cancelSubscription() throws Exception {
    registryClient.delete("/subscription/cancel");
  }

  public void updatePaymentMethod(Long cardId) throws Exception {
    registryClient.put("/subscription/change-payment-method/" + cardId, SubscriptionResponse.class);
  }

  public SubscriptionResponse getSubscription() {
    return registryClient.get("/subscription", SubscriptionResponse.class);
  }
}
