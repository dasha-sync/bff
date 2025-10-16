package api.controller;

import api.dto.card.AddCardRequest;
import api.dto.card.CardResponse;
import api.dto.common.ApiResponse;
import api.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
  private final CardService cardService;

  @PostMapping("/add")
  public ResponseEntity<ApiResponse<CardResponse>> addCard(
      @Valid @RequestBody AddCardRequest request) throws Exception {
    CardResponse card = cardService.addCard(request);
    return ResponseEntity.ok(new ApiResponse<>("Card added successfully", card));
  }

  @GetMapping
  public ResponseEntity<ApiResponse<List<CardResponse>>> getCards() {
    List<CardResponse> cards = cardService.getCards();
    return ResponseEntity.ok(new ApiResponse<>("User cards", cards));
  }
}
