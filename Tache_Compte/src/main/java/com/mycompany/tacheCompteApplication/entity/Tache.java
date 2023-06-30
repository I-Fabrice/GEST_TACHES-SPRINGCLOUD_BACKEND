package com.mycompany.tacheCompteApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Tache {
    private Long   ref;
    private String designation;
    private String description;
    private Date delai;
    private boolean isPriority;
    private boolean isDeleted;
    private Long groupeId;
    private Long statutId;
}
