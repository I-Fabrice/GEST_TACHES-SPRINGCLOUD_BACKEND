package com.mycompany.tacheApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Tache {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   ref;
    @Value("${some.key:Nouvelle Tache}")
    private String designation;
    private String description;
    private Date   delai;
    @Value("${some.key:false}")
    private boolean isPriority;
    @Value("${some.key:false}")
    private boolean isDeleted;
    private Long groupeId;
    private Long statutId;
    @Transient
    private Groupe groupe;
    @Transient
    private Statut statut;


}
