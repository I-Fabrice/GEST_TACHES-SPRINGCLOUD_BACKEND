package com.mycompany.projetCompte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProjetCompte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long      ref;
    private Long compteId;
    private Long projetId;
    @Transient
    private Compte compte;
    @Transient
    private Projet projet;
}
