package com.mycompany.statutApplication.services;

import com.mycompany.statutApplication.dto.DesignationRequestDTO;
import com.mycompany.statutApplication.dto.StatutResponseDTO;
import com.mycompany.statutApplication.entity.Statut;

public interface IStatutService {

    void create(Statut statut);
    String updateStatut(DesignationRequestDTO designationRequestDTO);

    StatutResponseDTO loadStatutById(Long ref);
    Statut  loadById(Long ref);

    Statut loadByDesignation(String designation);

}
