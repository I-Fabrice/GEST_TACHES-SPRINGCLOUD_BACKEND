package com.mycompany.tacheApplication.controller;


import com.mycompany.tacheApplication.dto.*;
import com.mycompany.tacheApplication.entity.Tache;
import com.mycompany.tacheApplication.services.ITacheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tache/")
public class TacheController {

    private final ITacheService service;

    public TacheController(ITacheService service) {
        this.service = service;
    }
    @PostMapping("{groupeId}")
    public TacheResponseDTO createTache(@PathVariable Long groupeId) {

        try{
            return service.createTache(groupeId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @PutMapping("edit/st")
    public String setStatut(@RequestBody StatutRequestDTO statutRequestDTO) {

        try{
            return service.setStatut(statutRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @PutMapping("edit/tk")
    public String editTache(@RequestBody TacheRequestDTO tacheRequestDTO) {
        try{
            return service.editTache(tacheRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }

    }

    @GetMapping("{groupeId}")
    public List<TacheResponseDTO> loadTacheByGroupeId(Long groupeId) {
        try{
            return service.loadTacheByGroupeId(groupeId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }


    @GetMapping("tk/{ref}")
    public TacheResponseDTO2 loadTacheByRef(@PathVariable Long ref) {
        try{
            return service.loadTacheByRef(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }

    }

    @PutMapping("edit/ds")
    public String setDesignation(@RequestBody DesignationRequestDTO designationRequestDTO) {
        try{
            return service.setDesignation(designationRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
