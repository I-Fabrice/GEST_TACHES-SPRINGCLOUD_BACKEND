package com.mycompany.projetCompte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
public class ProjetCompte
{
    public static void main(String[] args) {
        SpringApplication.run(ProjetCompte.class, args);
    }
}
