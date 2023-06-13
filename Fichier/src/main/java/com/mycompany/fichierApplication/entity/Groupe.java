package com.mycompany.fichierApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Groupe {

    private Long   ref;
    private String designation;
    private String description;
    private boolean isDeleted;

}
