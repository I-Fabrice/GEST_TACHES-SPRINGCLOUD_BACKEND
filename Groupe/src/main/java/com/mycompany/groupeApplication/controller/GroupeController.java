package com.mycompany.groupeApplication.controller;

import com.mycompany.groupeApplication.dto.DesignationRequestDTO;
import com.mycompany.groupeApplication.dto.GroupeResponseDTO;
import com.mycompany.groupeApplication.entity.Groupe;
import com.mycompany.groupeApplication.services.IGroupeService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groupe/")
public class GroupeController {

    private final IGroupeService service;

    public GroupeController(IGroupeService service) {
        this.service = service;
    }

    @GetMapping("{ref}")
    public Groupe loadById(@PathVariable Long ref) {
        try {
            return service.loadById(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @GetMapping("ld/{projetId}")
    public List<GroupeResponseDTO> loadGroupesByprojetId(@PathVariable Long projetId) {
        try{
            return service.loadGroupesByprojetId(projetId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @PostMapping("{projetId}")
    public GroupeResponseDTO create(@PathVariable Long projetId) {
        try{
            return service.create(projetId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }

    }

    @PutMapping("edit")
    public String setDesignation(@RequestBody DesignationRequestDTO designationRequestDTO) {
       try{
           return service.setDesignation(designationRequestDTO);
       }catch (RuntimeException r){
           throw new RuntimeException(r.getMessage());
       }
    }

    @DeleteMapping("{ref}")
    public String deleteGroupe(@PathVariable Long ref) {
        try{
            return service.deleteGroupe(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
