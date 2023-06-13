package com.mycompany.projetCompte.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

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
