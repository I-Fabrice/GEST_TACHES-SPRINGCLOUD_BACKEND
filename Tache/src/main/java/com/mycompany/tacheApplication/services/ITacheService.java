package com.mycompany.tacheApplication.services;

import com.mycompany.tacheApplication.dto.*;
import com.mycompany.tacheApplication.entity.Tache;

import java.util.Date;
import java.util.List;

public interface ITacheService {

    TacheResponseDTO createTache(Long goupeId);

    String deleteTache(Long ref);
    String update(Tache tache);

    String editTache(TacheRequestDTO tacheRequestDTO);

    List<TacheResponseDTO> loadTacheByGroupeId(Long groupeId);

    TacheResponseDTO2 loadTacheByRef(Long ref);

    String setDesignation(DesignationRequestDTO designationRequestDTO);

    String setStatut(StatutRequestDTO statutRequestDTO);

    EditResponseDTO getTache(Long ref);

    List<TacheResponseDTO> loadAlltache();

    // String setDescription(DescriptionRequestDTO descriptionRequestDTO);

    // Date setDelai(DelaiRequestDTO delaiRequestDTO);


}
