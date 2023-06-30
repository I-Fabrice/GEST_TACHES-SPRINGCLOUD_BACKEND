package com.mycompany.tacheCompteApplication.mapper;

import com.mycompany.tacheCompteApplication.dto.CompteResponseDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteRequestDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteResponseDTO;
import com.mycompany.tacheCompteApplication.entity.Compte;
import com.mycompany.tacheCompteApplication.entity.TacheCompte;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-24T21:49:15+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ITacheCompteMapperImpl implements ITacheCompteMapper {

    @Override
    public TacheCompte TacheCompteRequestDTOToTacheCompte(TacheCompteRequestDTO tacheCompteRequestDTO) {
        if ( tacheCompteRequestDTO == null ) {
            return null;
        }

        TacheCompte tacheCompte = new TacheCompte();

        tacheCompte.setTacheId( tacheCompteRequestDTO.getTacheId() );
        tacheCompte.setCompteId( tacheCompteRequestDTO.getCompteId() );

        return tacheCompte;
    }

    @Override
    public TacheCompteResponseDTO TacheCompteToTacheCompteResponseDTO(TacheCompte tacheCompte) {
        if ( tacheCompte == null ) {
            return null;
        }

        TacheCompteResponseDTO tacheCompteResponseDTO = new TacheCompteResponseDTO();

        tacheCompteResponseDTO.setTacheId( tacheCompte.getTacheId() );

        return tacheCompteResponseDTO;
    }

    @Override
    public CompteResponseDTO CompteToCompteResponseDTO(Compte compte) {
        if ( compte == null ) {
            return null;
        }

        CompteResponseDTO compteResponseDTO = new CompteResponseDTO();

        compteResponseDTO.setRef( compte.getRef() );
        compteResponseDTO.setNom( compte.getNom() );

        return compteResponseDTO;
    }
}
