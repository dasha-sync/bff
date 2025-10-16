package api.dto.resourceStats;

import lombok.Data;

@Data
public class ResourceUpdateRequest {
  private Integer cpu;
  private Integer ram;
  private Integer traffic;
}

