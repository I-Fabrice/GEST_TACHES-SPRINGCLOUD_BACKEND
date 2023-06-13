package com.mycompany.statutApplication.mapper;

import com.mycompany.statutApplication.dto.StatutResponseDTO;
import com.mycompany.statutApplication.entity.Statut;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T13:42:42+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class IStatutMapperImpl implements IStatutMapper {

    @Override
    public StatutResponseDTO statutToStatutResponseDTO(Statut statut) {
        if ( statut == null ) {
            return null;
        }

        StatutResponseDTO statutResponseDTO = new StatutResponseDTO();

        statutResponseDTO.setRef( statut.getRef() );
        statutResponseDTO.setDesignation( statut.getDesignation() );

        return statutResponseDTO;
    }
}
