package com.mycompany.tacheCompteApplication.mapper;

import com.mycompany.tacheCompteApplication.dto.CompteResponseDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteRequestDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteResponseDTO;
import com.mycompany.tacheCompteApplication.entity.Compte;
import com.mycompany.tacheCompteApplication.entity.Tache;
import com.mycompany.tacheCompteApplication.entity.TacheCompte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITacheCompteMapper {
    TacheCompte TacheCompteRequestDTOToTacheCompte(TacheCompteRequestDTO tacheCompteRequestDTO);

    TacheCompteResponseDTO TacheCompteToTacheCompteResponseDTO(TacheCompte tacheCompte);

    CompteResponseDTO CompteToCompteResponseDTO(Compte compte);
}
