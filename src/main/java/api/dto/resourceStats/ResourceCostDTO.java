package api.dto.resourceStats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceCostDTO {
  private Double cpuCost;
  private Double ramCost;
  private Double gbCost;
  private Double collCost;
}

