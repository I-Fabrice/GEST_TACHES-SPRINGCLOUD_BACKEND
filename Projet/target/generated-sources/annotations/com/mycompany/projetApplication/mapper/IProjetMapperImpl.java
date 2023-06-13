package com.mycompany.projetApplication.mapper;

import com.mycompany.projetApplication.dto.ProjetResponseDTO;
import com.mycompany.projetApplication.entity.Projet;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T18:41:30+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class IProjetMapperImpl implements IProjetMapper {

    @Override
    public ProjetResponseDTO projetToProjetResponseDTO(Projet projet) {
        if ( projet == null ) {
            return null;
        }

        ProjetResponseDTO projetResponseDTO = new ProjetResponseDTO();

        projetResponseDTO.setRef( projet.getRef() );
        projetResponseDTO.setDesignation( projet.getDesignation() );

        return projetResponseDTO;
    }
}
