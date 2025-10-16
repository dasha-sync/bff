package api.service;

import api.client.RegistryClient;
import api.dto.faas.FaasResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaasService {
  private final RegistryClient registryClient;

  public Map<String, Object> getFaas() {
    return registryClient.get("/faas", Map.class);
  }
}
