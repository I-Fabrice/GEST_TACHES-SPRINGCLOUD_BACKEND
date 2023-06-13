package com.mycompany.fichierApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Fichier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   ref;
    @Column @Lob
    private String designation;
    private String extension;
    @Value("${some.key:false}")
    private boolean isDeleted;
    private Long groupeId;
    @Transient
    private Groupe groupe;
}
