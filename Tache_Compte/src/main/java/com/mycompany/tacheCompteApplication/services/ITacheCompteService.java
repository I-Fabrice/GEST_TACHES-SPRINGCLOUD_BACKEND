package com.mycompany.tacheCompteApplication.services;

import com.mycompany.tacheCompteApplication.dto.CompteResponseDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteRequestDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteResponseDTO;
import com.mycompany.tacheCompteApplication.entity.TacheCompte;

import java.util.List;

public interface ITacheCompteService {
    String create(List<TacheCompteRequestDTO> tacheCompteRequestDTO);
    List<TacheCompteResponseDTO> getAllTacheCompteByCompteId(Long compteId);

    List<CompteResponseDTO> getAllTacheCompteByTacheId(Long tacheId);

}
