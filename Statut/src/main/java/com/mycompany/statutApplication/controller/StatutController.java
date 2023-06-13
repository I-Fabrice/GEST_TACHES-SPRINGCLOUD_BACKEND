package com.mycompany.statutApplication.controller;

import com.mycompany.statutApplication.dto.StatutResponseDTO;
import com.mycompany.statutApplication.entity.Statut;
import com.mycompany.statutApplication.services.IStatutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/statut")
public class StatutController {

    private final IStatutService service;

    public StatutController(IStatutService service) {
        this.service = service;
    }

    @GetMapping("{ref}")
    public StatutResponseDTO loadStatutById(@PathVariable Long ref) {
        try{
            return service.loadStatutById(ref);
        }catch (RuntimeException r){
            throw  new RuntimeException(r.getMessage());
        }
    }

    @GetMapping("/ds/{designation}")
    public Statut loadByDesignation(@PathVariable String designation) {
        try{
            return service.loadByDesignation(designation);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
