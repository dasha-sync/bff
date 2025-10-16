package api.dto.resourceStats;

import lombok.Data;

@Data
public class ResourceCostRequest {
  private Double cpuCost;
  private Double gbCost;
  private Double trafficCost;
}

