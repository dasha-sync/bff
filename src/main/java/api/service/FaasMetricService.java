package api.service;

import api.dto.metric.MetricResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaasMetricService {

  private static final String PROMETHEUS_URL = "http://prometheus:9090/api/v1/query_range";
  private final RestTemplate restTemplate = new RestTemplate();

  public MetricResponse getFaas(String function, String metricType) {
    try {
      String query = metricType + "{function=\"" + function + "\", application=\"metrics\"}";

      Instant end = Instant.now();
      Instant start = end.minus(Duration.ofHours(1)); // last 1 hour
      String step = "30s"; // data point every 30 seconds

      String url = UriComponentsBuilder.fromHttpUrl(PROMETHEUS_URL)
          .queryParam("query", query)
          .queryParam("start", start.getEpochSecond())
          .queryParam("end", end.getEpochSecond())
          .queryParam("step", step)
          .build(false)
          .encode()
          .toUriString();

      Map<String, Object> response = restTemplate.getForObject(url, Map.class);
      return new MetricResponse("success", response);
    } catch (Exception e) {
      log.error("Error fetching time series metrics from Prometheus", e);
      return new MetricResponse("error", e.getMessage());
    }
  }
}
