package api.dto.resourceStats;

import lombok.Data;

@Data
public class ResourceCostRequest {
  private Double cpuCost;
  private Double ramCost;
  private Double gbCost;
  private Double collCost;
}

