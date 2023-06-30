package com.mycompany.tacheApplication.controller;


import com.mycompany.tacheApplication.dto.*;
import com.mycompany.tacheApplication.entity.Tache;
import com.mycompany.tacheApplication.services.ITacheService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tache/")
public class TacheController {

    private final ITacheService service;

    public TacheController(ITacheService service) {
        this.service = service;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("{groupeId}")
    public TacheResponseDTO createTache(@PathVariable Long groupeId) {

        try{
            return service.createTache(groupeId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("{tacheId}")
    public String deleteTache(@PathVariable Long tacheId) {
        try{
            return service.deleteTache(tacheId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("edit/st")
    public String setStatut(@RequestBody StatutRequestDTO statutRequestDTO) {

        try{
            return service.setStatut(statutRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("edit/tk")
    public String editTache(@RequestBody TacheRequestDTO tacheRequestDTO) {
        try{
            return service.editTache(tacheRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{groupeId}")
    public List<TacheResponseDTO> loadTacheByGroupeId(@PathVariable Long groupeId) {
        try{
            return service.loadTacheByGroupeId(groupeId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<TacheResponseDTO> loadAllTache() {
        try{
            return service.loadAlltache();
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("tk/{ref}")
    public TacheResponseDTO2 loadTacheByRef(@PathVariable Long ref) {
        try{
            return service.loadTacheByRef(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("edit/ds")
    public String setDesignation(@RequestBody DesignationRequestDTO designationRequestDTO) {
        try{
            return service.setDesignation(designationRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("ld/{ref}")
    public EditResponseDTO getTache(@PathVariable Long ref) {
        try{
            return service.getTache(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
