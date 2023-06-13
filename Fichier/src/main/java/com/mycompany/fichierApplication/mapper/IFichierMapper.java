package com.mycompany.fichierApplication.mapper;

import com.mycompany.fichierApplication.dto.FichierRequestDTO;
import com.mycompany.fichierApplication.dto.FichierResponseDTO;
import com.mycompany.fichierApplication.entity.Fichier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IFichierMapper {
    FichierResponseDTO FichierToFichierResponseDTO(Fichier fichier);

    Fichier FichierRequestDTOToFichier(FichierRequestDTO fichierRequestDTO);
}
