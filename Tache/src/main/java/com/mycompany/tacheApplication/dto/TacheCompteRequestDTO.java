package com.mycompany.tacheApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class TacheCompteRequestDTO {
    private Long tacheId;
    private Long compteId;
}
