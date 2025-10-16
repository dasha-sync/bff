package api.service;

import api.client.RegistryClient;
import api.dto.faas.FaasResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaasService {
  private final RegistryClient registryClient;

  public List<FaasResponse> getFaas() {
    return registryClient.get("/faas", List.class);
  }
}
