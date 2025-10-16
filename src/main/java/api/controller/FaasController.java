package api.controller;

import api.dto.common.MetricResponse;
import api.dto.faas.FaasResponse;
import api.service.FaasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/faas")
@RequiredArgsConstructor
public class FaasController {
  private final FaasService faasService;

  @GetMapping
  public ResponseEntity< MetricResponse<Map<String, Object>>> getFaas() {
    Map<String, Object> faas = faasService.getFaas();
    return ResponseEntity.ok(new MetricResponse<>("User FaaS functions", faas));
  }
}

