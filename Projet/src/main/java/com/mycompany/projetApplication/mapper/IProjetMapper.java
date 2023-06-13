package com.mycompany.projetApplication.mapper;

import com.mycompany.projetApplication.dto.ProjetResponseDTO;
import com.mycompany.projetApplication.entity.Projet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProjetMapper {
    ProjetResponseDTO projetToProjetResponseDTO(Projet projet);
}
