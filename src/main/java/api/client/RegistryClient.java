package api.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RegistryClient {

  private final RestTemplate restTemplate;
  private final String baseUrl;

  public RegistryClient(@Value("${registry.base-url}") String baseUrl) {
    this.restTemplate = new RestTemplate();
    this.baseUrl = baseUrl;
  }

  public <T> T get(String path, Class<T> responseType) {
    return restTemplate.getForObject(baseUrl + path, responseType);
  }

  public <T, R> R post(String path, T requestBody, Class<R> responseType) {
    return restTemplate.postForObject(baseUrl + path, requestBody, responseType);
  }

  public void delete(String path) {
    restTemplate.delete(baseUrl + path);
  }

  public <T> void put(String path, T requestBody) {
    restTemplate.put(baseUrl + path, requestBody);
  }
}
