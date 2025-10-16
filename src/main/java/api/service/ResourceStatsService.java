package api.service;

import api.client.RegistryClient;
import api.dto.resourceStats.ResourceCostRequest;
import api.dto.resourceStats.ResourceResponse;
import api.dto.resourceStats.ResourceUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceStatsService {
  private final RegistryClient registryClient;

  public ResourceResponse getAll() {
    return registryClient.get("/resource", ResourceResponse.class);
  }

  public void updateCost(ResourceCostRequest dto) {
    registryClient.put("/resource/update-costs", dto);
  }
}
