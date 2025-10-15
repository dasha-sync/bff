package api.service;

import api.dto.metric.MetricResponse;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.regex.Pattern;
import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaasMetricService {

  private static final String PROMETHEUS_URL = "http://prometheus:9090/api/v1/query_range";
  private static final Pattern METRIC_NAME_PATTERN = Pattern.compile("^[a-zA-Z_:][a-zA-Z0-9_:]*$");
  private final RestTemplate restTemplate = new RestTemplate();
  private final MeterRegistry meterRegistry;

  public MetricResponse getFaas(String function, String metricType) {
    try {
      // Validate metric name to prevent malformed PromQL like "metric[7]"
      if (metricType == null || !METRIC_NAME_PATTERN.matcher(metricType).matches()) {
        return new MetricResponse(
            "error",
            "Invalid metric name. Only simple Prometheus metric names are allowed (letters, digits, _, :)."
        );
      }

      String safeFunction = function == null ? "" : function.replace("\\", "\\\\").replace("\"", "\\\"");

      String query = metricType + "{function=\"" + safeFunction + "\"}";

      Instant end = Instant.now();
      Instant start = end.minus(Duration.ofHours(1));
      String step = "30s";

      URI uri = UriComponentsBuilder.fromHttpUrl(PROMETHEUS_URL)
          .queryParam("query", query)
          .queryParam("start", start.getEpochSecond())
          .queryParam("end", end.getEpochSecond())
          .queryParam("step", step)
          .build()
          .encode()
          .toUri();

      log.info("Prometheus query_range URI: {}", uri);

      Map<String, Object> response = restTemplate.getForObject(uri, Map.class);
      log.info("Prometheus query_range response: {}", response);
      return new MetricResponse("success", response);
    } catch (Exception e) {
      log.error("Error fetching time series metrics from Prometheus", e);
      return new MetricResponse("error", e.getMessage());
    }
  }

  public MetricResponse mockMetric(String funcName, int count) {
    try {
      if (count < 0) {
        return new MetricResponse("error", "count must be >= 0");
      }
      Counter counter = Counter
          .builder("metric1")
          .tag("function", funcName)
          .register(meterRegistry);
      if (count > 0) {
        counter.increment(count);
      }
      return new MetricResponse("success", String.format("metric1 incremented by %d for function=%s", count, funcName));
    } catch (Exception e) {
      log.error("Error mocking metric emission", e);
      return new MetricResponse("error", e.getMessage());
    }
  }
}