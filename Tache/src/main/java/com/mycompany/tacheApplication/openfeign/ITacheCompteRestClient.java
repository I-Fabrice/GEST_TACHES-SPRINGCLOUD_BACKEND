package com.mycompany.tacheApplication.openfeign;

import com.mycompany.tacheApplication.dto.CompteResponseDTO;
import com.mycompany.tacheApplication.dto.TacheCompteRequestDTO;
import com.mycompany.tacheApplication.dto.TacheCompteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "tachecompte-service", url = "localhost:8087")
public interface ITacheCompteRestClient {
    @PostMapping("api/v1/tachecompte/")
    String create(@RequestBody List<TacheCompteRequestDTO> tacheCompteRequestDTO);

    @GetMapping("/api/v1/tachecompte/t/{tacheId}")
    List<CompteResponseDTO> getAllTacheCompteByTacheId(@PathVariable("tacheId") Long tacheId);
}
