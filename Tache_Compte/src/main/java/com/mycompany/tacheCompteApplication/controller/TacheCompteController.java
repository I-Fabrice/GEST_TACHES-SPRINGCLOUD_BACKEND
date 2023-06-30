package com.mycompany.tacheCompteApplication.controller;

import com.mycompany.tacheCompteApplication.dto.CompteResponseDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteRequestDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteResponseDTO;
import com.mycompany.tacheCompteApplication.entity.TacheCompte;
import com.mycompany.tacheCompteApplication.services.ITacheCompteService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tachecompte/")
public class TacheCompteController {
    private final ITacheCompteService service;

    public TacheCompteController(ITacheCompteService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public String create(@RequestBody List<TacheCompteRequestDTO> tacheCompteRequestDTO) {
        try{
            return service.create(tacheCompteRequestDTO);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{compteId}")
    public List<TacheCompteResponseDTO> getAllTacheCompteByCompteId(@PathVariable Long compteId) {

        try{
            return service.getAllTacheCompteByCompteId(compteId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("t/{tacheId}")
    public List<CompteResponseDTO> getAllTacheCompteByTacheId(@PathVariable("tacheId") Long tacheId) {
        try{
            return service.getAllTacheCompteByTacheId(tacheId);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
