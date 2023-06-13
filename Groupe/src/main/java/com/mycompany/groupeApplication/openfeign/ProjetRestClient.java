package com.mycompany.groupeApplication.openfeign;

import com.mycompany.groupeApplication.dto.ProjetResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "projet-service", url = "projet")
public interface ProjetRestClient {

    @GetMapping("/api/v1/projet/{ref}")
    ProjetResponseDTO loadProjetByRef(@RequestParam("ref") Long ref);
}
