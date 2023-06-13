package com.mycompany.groupeApplication.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Projet {

    private Long   ref;
    private String designation;
    private boolean isDeleted;
}
