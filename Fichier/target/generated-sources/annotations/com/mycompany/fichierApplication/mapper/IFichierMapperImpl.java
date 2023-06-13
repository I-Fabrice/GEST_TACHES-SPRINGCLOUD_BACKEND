package com.mycompany.fichierApplication.mapper;

import com.mycompany.fichierApplication.dto.FichierRequestDTO;
import com.mycompany.fichierApplication.dto.FichierResponseDTO;
import com.mycompany.fichierApplication.entity.Fichier;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T18:09:17+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class IFichierMapperImpl implements IFichierMapper {

    @Override
    public FichierResponseDTO FichierToFichierResponseDTO(Fichier fichier) {
        if ( fichier == null ) {
            return null;
        }

        FichierResponseDTO fichierResponseDTO = new FichierResponseDTO();

        fichierResponseDTO.setRef( fichier.getRef() );
        fichierResponseDTO.setDesignation( fichier.getDesignation() );
        fichierResponseDTO.setExtension( fichier.getExtension() );

        return fichierResponseDTO;
    }

    @Override
    public Fichier FichierRequestDTOToFichier(FichierRequestDTO fichierRequestDTO) {
        if ( fichierRequestDTO == null ) {
            return null;
        }

        Fichier fichier = new Fichier();

        fichier.setDesignation( fichierRequestDTO.getDesignation() );
        fichier.setExtension( fichierRequestDTO.getExtension() );
        fichier.setGroupeId( fichierRequestDTO.getGroupeId() );

        return fichier;
    }
}
