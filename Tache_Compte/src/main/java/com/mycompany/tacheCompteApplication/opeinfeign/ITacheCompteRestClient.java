package com.mycompany.tacheCompteApplication.opeinfeign;

import com.mycompany.tacheCompteApplication.entity.Compte;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tachecompte-service", url = "localhost:8080")
public interface ITacheCompteRestClient {
    @GetMapping("/api/v1/compte/{ref}")
    Compte loadCompteById(@PathVariable("ref") Long ref);
}
