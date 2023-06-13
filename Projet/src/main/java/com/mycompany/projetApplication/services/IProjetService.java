package com.mycompany.projetApplication.services;

import com.mycompany.projetApplication.dto.DesignationRequestDTO;
import com.mycompany.projetApplication.dto.ProjetResponseDTO;
import com.mycompany.projetApplication.entity.Projet;

public interface IProjetService {

    ProjetResponseDTO create(String designation);

    String updateProjet(Projet projet);

    String setDesignation(DesignationRequestDTO designationRequestDTO);

    String deleteProjet(Long ref);

    ProjetResponseDTO loadProjetByRef(Long ref);
}
