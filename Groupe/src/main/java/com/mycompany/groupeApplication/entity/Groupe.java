package com.mycompany.groupeApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Groupe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   ref;
    @Value("${some.key: Nouveau groupe}")
    private String designation;
    @Value("${some.key:false}")
    private boolean isDeleted;
    private Long projetId;
    @Transient
    private Projet projet;
}
