package com.mycompany.tacheApplication.openfeign;

import com.mycompany.tacheApplication.dto.StatutResponseDTO;
import com.mycompany.tacheApplication.entity.Statut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "statut-service", url = "localhost:8085")
public interface IStatutRestClient {

    @GetMapping("/api/v1/statut/{ref}")
    StatutResponseDTO loadStatutById(@PathVariable("ref") Long ref);

    @GetMapping("/api/v1/statut/ds/{designation}")
    Statut loadByDesignation(@PathVariable("designation") String designation);


}
