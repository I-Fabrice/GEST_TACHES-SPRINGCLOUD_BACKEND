package com.mycompany.groupeApplication.services;

import com.mycompany.groupeApplication.dto.DesignationRequestDTO;
import com.mycompany.groupeApplication.dto.GroupeRequestDTO;
import com.mycompany.groupeApplication.dto.GroupeResponseDTO;
import com.mycompany.groupeApplication.entity.Groupe;

import java.util.List;

public interface IGroupeService {
    GroupeResponseDTO create(Long projetId);

    String updateGroupe(Groupe groupe);

    String setDesignation(DesignationRequestDTO designationRequestDTO);

    String deleteGroupe(Long ref);

    Groupe loadById(Long ref);

    List<GroupeResponseDTO> loadGroupesByprojetId(Long projetId);
}
