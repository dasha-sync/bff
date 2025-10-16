package api.dto.faas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaasResponse {
  private Long id;
  private String funcName;
  private String metricName;
  private Long metricValue;
  private OffsetDateTime ts;
}
