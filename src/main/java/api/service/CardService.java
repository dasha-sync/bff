package api.service;

import api.client.RegistryClient;
import api.dto.card.AddCardRequest;
import api.dto.card.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CardService {
  private final RegistryClient registryClient;

  public CardResponse addCard(AddCardRequest request) throws Exception {
    return registryClient.post("/cards/add", request, CardResponse.class);
  }

  public List<CardResponse> getCards() {
    return registryClient.get("/cards", List.class);
  }
}
