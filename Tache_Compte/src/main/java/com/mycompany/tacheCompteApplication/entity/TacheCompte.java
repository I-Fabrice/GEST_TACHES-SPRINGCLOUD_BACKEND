package com.mycompany.tacheCompteApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class TacheCompte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   ref;
    private Long tacheId;
    private Long compteId;
    @Transient
    private Tache tache;
    @Transient
    private Compte compte;
}
