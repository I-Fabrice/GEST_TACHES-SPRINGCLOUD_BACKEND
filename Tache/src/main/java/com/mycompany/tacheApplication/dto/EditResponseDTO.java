package com.mycompany.tacheApplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class EditResponseDTO {
    private Long   ref;
    private String description;
    private Date delai;
    private boolean isPriority;
    private List<CompteResponseDTO> compteResponseDTOS;
}
