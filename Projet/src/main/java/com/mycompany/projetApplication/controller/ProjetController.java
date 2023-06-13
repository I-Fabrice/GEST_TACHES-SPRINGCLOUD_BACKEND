package com.mycompany.projetApplication.controller;

import com.mycompany.projetApplication.dto.DesignationRequestDTO;
import com.mycompany.projetApplication.dto.ProjetResponseDTO;
import com.mycompany.projetApplication.entity.Projet;
import com.mycompany.projetApplication.services.IProjetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projet/")
public class ProjetController {
    private final IProjetService service;

    public ProjetController(IProjetService service) {
        this.service = service;
    }

    @PutMapping("{designation}")
    public ProjetResponseDTO create(@PathVariable String designation) {
        try{
            return  service.create(designation);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @GetMapping("{ref}")
    public ProjetResponseDTO loadProjetByRef(@PathVariable Long ref) {
        try{
            return  service.loadProjetByRef(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @PutMapping("edit")
    public String setDesignation(@RequestBody DesignationRequestDTO designationRequestDTO) {
        try{
            return service.setDesignation(designationRequestDTO);
        }catch(RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @DeleteMapping("{ref}")
    public String deleteProjet(@PathVariable Long ref) {
        try{
            return service.deleteProjet(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
