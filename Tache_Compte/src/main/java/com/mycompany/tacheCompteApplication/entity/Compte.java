package com.mycompany.tacheCompteApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Compte {

    private Long   ref;
    private String photo;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private boolean isDeleted;
}
