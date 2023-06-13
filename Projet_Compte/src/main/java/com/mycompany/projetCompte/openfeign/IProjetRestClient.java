package com.mycompany.projetCompte.openfeign;

import com.mycompany.projetCompte.dto.ProjetResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "projet-service", url = "localhost:8082")
public interface IProjetRestClient {

    @PutMapping("/api/v1/projet/{designation}")
    ProjetResponseDTO create(@PathVariable("designation") String designation);

    @GetMapping("/api/v1/projet/{ref}")
    ProjetResponseDTO loadProjetByRef(@PathVariable("ref") Long ref);
}
