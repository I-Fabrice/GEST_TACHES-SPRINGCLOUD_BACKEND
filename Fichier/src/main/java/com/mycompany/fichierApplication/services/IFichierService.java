package com.mycompany.fichierApplication.services;

import com.mycompany.fichierApplication.dto.FichierRequestDTO;
import com.mycompany.fichierApplication.dto.FichierResponseDTO;
import com.mycompany.fichierApplication.entity.Fichier;

import java.util.List;

public interface IFichierService {

   FichierResponseDTO createFichier(FichierRequestDTO fichierRequestDTO);

   List<FichierResponseDTO> loadByGroupeId(Long GroupeId);
   void updateFichier(Fichier fichier);
   Fichier loadById(Long ref);
   String deleteFichier(Long ref);

}
