package api.dto.kafka;

import lombok.Data;

import java.util.Map;

@Data
public class MetricsEvent {
  private String funcName;
  private Long metric1;
  private Long metric2;
  private Long metric3;

  public Map<String, Long> toMetricsMap() {
    return Map.of(
        "metric1", metric1,
        "metric2", metric2,
        "metric3", metric3
    );
  }
}
