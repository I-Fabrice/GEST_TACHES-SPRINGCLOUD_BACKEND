package com.mycompany.compteApplication.config;

import com.mycompany.compteApplication.entity.Compte;
import com.mycompany.compteApplication.services.CompteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

// @Configuration
public class CompteConfig {
    private  final CompteService service;

    public CompteConfig(CompteService service) {
        this.service = service;
    }

    // @Bean
    public CommandLineRunner init_bills(){
        return args -> {
            service.createCompte(new Compte(null,"","Mapila","Fabrice",new Date(),"thef38997@gmail.com",false));
            service.createCompte(new Compte(null,"","Elenga","Pedro",new Date(),"pedro03@gmail.com",false));
        };
    }
}
