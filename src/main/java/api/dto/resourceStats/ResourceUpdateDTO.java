package api.dto.resourceStats;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceUpdateDTO {
  private Integer cpu;
  private Integer ram;
  private Integer traffic;
}

