package com.mycompany.tacheApplication.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class Statut {

    private Long   ref;
    private String designation;
    private boolean isDeleted;

}
