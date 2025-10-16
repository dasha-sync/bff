package api.dto.faas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaasRequest {
  private String funcName;
  private String metricName;
  private Long metricValue; // optional
}
