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
  private Integer gb;
  private Integer calls;
  private Double cpuCost;
  private Double ramCost;
  private Double gbCost;
  private Double collCost;
}

