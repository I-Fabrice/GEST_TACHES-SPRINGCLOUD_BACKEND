package com.mycompany.statutApplication.mapper;

import com.mycompany.statutApplication.dto.StatutResponseDTO;
import com.mycompany.statutApplication.entity.Statut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStatutMapper {

    StatutResponseDTO statutToStatutResponseDTO(Statut statut);
}
