package com.mycompany.tacheApplication.dto;

import com.mycompany.tacheApplication.entity.Groupe;
import com.mycompany.tacheApplication.entity.Statut;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TacheResponseDTO {

    private Long   ref;
    private String designation;
    private Long groupeId;
    private StatutResponseDTO statutResponseDTO;

}
