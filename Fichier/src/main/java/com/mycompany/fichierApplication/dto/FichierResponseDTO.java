package com.mycompany.fichierApplication.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FichierResponseDTO {
    private Long   ref;
    private String designation;
    private String extension;
}
