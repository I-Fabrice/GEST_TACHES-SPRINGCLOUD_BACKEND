package com.mycompany.tacheApplication.mapper;

import com.mycompany.tacheApplication.dto.*;
import com.mycompany.tacheApplication.entity.Statut;
import com.mycompany.tacheApplication.entity.Tache;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITacheMapper {
    TacheResponseDTO tacheToTacheResponseDTO(Tache tache);

    TacheResponseDTO2 tacheToTacheResponseDTO2(Tache tache);

    Tache tacheRequestDTOToTache(TacheRequestDTO tacheRequestDTO);
    Statut statutResponseDTOToStatut(StatutResponseDTO statutResponseDTO);

    EditResponseDTO TacheToEditResponseDTO(Tache tache);
}
