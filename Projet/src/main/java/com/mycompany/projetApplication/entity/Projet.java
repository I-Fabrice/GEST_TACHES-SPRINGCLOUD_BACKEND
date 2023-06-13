package com.mycompany.projetApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Projet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   ref;
    @Value("${some.key: Nouveau Projet}")
    private String designation;
    @Value("${some.key:false}")
    private boolean isDeleted;
}
