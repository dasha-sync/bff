package api.controller;

import api.dto.metric.MetricRequest;
import api.dto.metric.MetricResponse;
import api.service.FaasMetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/faas")
@RequiredArgsConstructor
public class FaasMetricController {
  private final FaasMetricService faasMetricService;

  @GetMapping
  public ResponseEntity<MetricResponse> getFaas(@RequestBody MetricRequest request) {
    MetricResponse metrics = faasMetricService.getFaas(request.getFuncName(), request.getMetric());
    return ResponseEntity.ok(metrics);
  }
}
