package com.mycompany.projetCompte.services;

import com.mycompany.projetCompte.dto.ProjetCompteRequestDTO;
import com.mycompany.projetCompte.dto.ProjetResponseDTO;

import java.util.List;

public interface IProjetCompteService {

    ProjetResponseDTO create(ProjetCompteRequestDTO projetCompteRequestDTO);
    List<ProjetResponseDTO> loadProjetsByCompte(Long compteId);
}
