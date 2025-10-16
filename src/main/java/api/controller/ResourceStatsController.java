package api.controller;

import api.dto.common.ApiResponse;
import api.dto.resourceStats.ResourceCostRequest;
import api.dto.resourceStats.ResourceResponse;
import api.dto.resourceStats.ResourceUpdateRequest;
import api.service.ResourceStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class ResourceStatsController {
  private final ResourceStatsService resourceStatsService;

  @GetMapping
  public ResponseEntity<ApiResponse<ResourceResponse>> getAll() {
    ResourceResponse response = resourceStatsService.getAll();
    return ResponseEntity.ok(
        new ApiResponse<>("Current resource statistics", response)
    );
  }

  @PutMapping("/update-costs")
  public ResponseEntity<ApiResponse<ResourceResponse>> updateCosts( @RequestBody ResourceCostRequest request) {
    resourceStatsService.updateCost(request);
    return ResponseEntity.noContent().build();
  }
}
