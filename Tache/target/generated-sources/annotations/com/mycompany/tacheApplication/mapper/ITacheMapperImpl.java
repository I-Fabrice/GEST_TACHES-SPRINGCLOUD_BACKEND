package com.mycompany.tacheApplication.mapper;

import com.mycompany.tacheApplication.dto.StatutResponseDTO;
import com.mycompany.tacheApplication.dto.TacheRequestDTO;
import com.mycompany.tacheApplication.dto.TacheResponseDTO;
import com.mycompany.tacheApplication.dto.TacheResponseDTO2;
import com.mycompany.tacheApplication.entity.Statut;
import com.mycompany.tacheApplication.entity.Tache;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T16:45:43+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ITacheMapperImpl implements ITacheMapper {

    @Override
    public TacheResponseDTO tacheToTacheResponseDTO(Tache tache) {
        if ( tache == null ) {
            return null;
        }

        TacheResponseDTO tacheResponseDTO = new TacheResponseDTO();

        tacheResponseDTO.setRef( tache.getRef() );
        tacheResponseDTO.setDesignation( tache.getDesignation() );

        return tacheResponseDTO;
    }

    @Override
    public TacheResponseDTO2 tacheToTacheResponseDTO2(Tache tache) {
        if ( tache == null ) {
            return null;
        }

        TacheResponseDTO2 tacheResponseDTO2 = new TacheResponseDTO2();

        tacheResponseDTO2.setRef( tache.getRef() );
        tacheResponseDTO2.setDesignation( tache.getDesignation() );
        tacheResponseDTO2.setDescription( tache.getDescription() );
        tacheResponseDTO2.setDelai( tache.getDelai() );
        tacheResponseDTO2.setPriority( tache.isPriority() );

        return tacheResponseDTO2;
    }

    @Override
    public Tache tacheRequestDTOToTache(TacheRequestDTO tacheRequestDTO) {
        if ( tacheRequestDTO == null ) {
            return null;
        }

        Tache tache = new Tache();

        tache.setRef( tacheRequestDTO.getRef() );
        tache.setDescription( tacheRequestDTO.getDescription() );
        tache.setDelai( tacheRequestDTO.getDelai() );
        tache.setPriority( tacheRequestDTO.isPriority() );

        return tache;
    }

    @Override
    public Statut statutResponseDTOToStatut(StatutResponseDTO statutResponseDTO) {
        if ( statutResponseDTO == null ) {
            return null;
        }

        Statut statut = new Statut();

        statut.setRef( statutResponseDTO.getRef() );
        statut.setDesignation( statutResponseDTO.getDesignation() );

        return statut;
    }
}
