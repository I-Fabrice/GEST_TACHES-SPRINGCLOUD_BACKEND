package com.mycompany.projetCompte.controller;

import com.mycompany.projetCompte.dto.ProjetCompteRequestDTO;
import com.mycompany.projetCompte.dto.ProjetResponseDTO;
import com.mycompany.projetCompte.services.IProjetCompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projetcompte/")
public class ProjetCompteController {

    private final IProjetCompteService service;

    public ProjetCompteController(IProjetCompteService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("cr")
    public ProjetResponseDTO create(@RequestBody ProjetCompteRequestDTO projetCompteRequestDTO) {

        try{
           return service.create(projetCompteRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{compteId}")
    public List<ProjetResponseDTO> loadProjetsByCompte(@PathVariable Long compteId) {

        try{
            return service.loadProjetsByCompte(compteId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
