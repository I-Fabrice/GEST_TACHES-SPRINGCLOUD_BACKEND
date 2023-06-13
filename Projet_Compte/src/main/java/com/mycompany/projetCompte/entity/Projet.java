package com.mycompany.projetCompte.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Projet {

    private Long   ref;
    private String designation;
    private boolean isDeleted;

}
