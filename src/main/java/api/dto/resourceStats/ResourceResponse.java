package api.dto.resourceStats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceResponse {
  private Integer cpu;
  private Integer ram;
  private Integer traffic;
  private Double cpuCost;
  private Double gbCost;
  private Double trafficCost;
}

