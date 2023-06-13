package com.mycompany.groupeApplication.mapper;

import com.mycompany.groupeApplication.dto.GroupeResponseDTO;
import com.mycompany.groupeApplication.entity.Groupe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IGroupeMapper {
    GroupeResponseDTO groupeToGroupeResponseDTO(Groupe groupe);

}
