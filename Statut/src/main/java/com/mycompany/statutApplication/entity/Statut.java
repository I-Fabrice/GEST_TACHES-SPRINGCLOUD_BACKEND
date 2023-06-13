package com.mycompany.statutApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Statut {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   ref;
    @NonNull
    private String designation;
    @Value("${some.key:false}")
    private boolean isDeleted;
}
