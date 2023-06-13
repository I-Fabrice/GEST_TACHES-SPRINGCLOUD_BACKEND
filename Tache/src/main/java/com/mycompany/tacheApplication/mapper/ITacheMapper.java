package com.mycompany.tacheApplication.mapper;

import com.mycompany.tacheApplication.dto.StatutResponseDTO;
import com.mycompany.tacheApplication.dto.TacheRequestDTO;
import com.mycompany.tacheApplication.dto.TacheResponseDTO;
import com.mycompany.tacheApplication.dto.TacheResponseDTO2;
import com.mycompany.tacheApplication.entity.Statut;
import com.mycompany.tacheApplication.entity.Tache;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ITacheMapper {
    TacheResponseDTO tacheToTacheResponseDTO(Tache tache);

    TacheResponseDTO2 tacheToTacheResponseDTO2(Tache tache);

    Tache tacheRequestDTOToTache(TacheRequestDTO tacheRequestDTO);
    Statut statutResponseDTOToStatut(StatutResponseDTO statutResponseDTO);
}
