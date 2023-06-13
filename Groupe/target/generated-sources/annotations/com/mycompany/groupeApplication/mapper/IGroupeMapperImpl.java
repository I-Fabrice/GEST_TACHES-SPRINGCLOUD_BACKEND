package com.mycompany.groupeApplication.mapper;

import com.mycompany.groupeApplication.dto.GroupeResponseDTO;
import com.mycompany.groupeApplication.entity.Groupe;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T17:48:40+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class IGroupeMapperImpl implements IGroupeMapper {

    @Override
    public GroupeResponseDTO groupeToGroupeResponseDTO(Groupe groupe) {
        if ( groupe == null ) {
            return null;
        }

        GroupeResponseDTO groupeResponseDTO = new GroupeResponseDTO();

        groupeResponseDTO.setRef( groupe.getRef() );
        groupeResponseDTO.setDesignation( groupe.getDesignation() );

        return groupeResponseDTO;
    }
}
