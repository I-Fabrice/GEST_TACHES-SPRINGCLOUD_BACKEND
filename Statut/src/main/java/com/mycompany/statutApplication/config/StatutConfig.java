package com.mycompany.statutApplication.config;

import com.mycompany.statutApplication.entity.Statut;
import com.mycompany.statutApplication.services.StatutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

// @Configuration
public class StatutConfig {

    private final StatutService statutService;

    public StatutConfig(StatutService statutService) {
        this.statutService = statutService;
    }

   // @Bean
    public CommandLineRunner init_bills(){
        return args -> {
            statutService.create(new Statut(null,"completed",false));
            statutService.create(new Statut(null,"not-completed",false));
            statutService.create(new Statut(null,"in-progress",false));
            statutService.create(new Statut(null,"not-start",false));
        };
    }
}
