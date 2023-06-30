package com.mycompany.compteApplication.controller;

import com.mycompany.compteApplication.entity.Compte;
import com.mycompany.compteApplication.services.ICompteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/compte/")
public class CompteController {
    private final ICompteService service;

    public CompteController(ICompteService service) {
        this.service = service;
    }

    @GetMapping("{ref}")
    public Compte loadCompteById(@PathVariable("ref") Long ref) {
        try{
            return service.loadById(ref);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("fd/{email}")
    public Compte loadByEmail(@PathVariable String email) {
        try{
            return service.loadByEmail(email);
        }catch (RuntimeException r){
            throw new RuntimeException(r.getMessage());
        }
    }
}
