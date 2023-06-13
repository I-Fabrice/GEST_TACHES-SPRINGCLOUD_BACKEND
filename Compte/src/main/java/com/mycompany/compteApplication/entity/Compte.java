package com.mycompany.compteApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   ref;
    private String photo;
    private String nom;
    private String prenom;
    private Date   dateNaissance;
    private String email;
    @Value("${some.key:false}")
    private boolean isDeleted;
}
