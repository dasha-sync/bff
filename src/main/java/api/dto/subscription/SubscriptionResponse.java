package api.dto.subscription;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SubscriptionResponse {
  private BigDecimal amount;
}
