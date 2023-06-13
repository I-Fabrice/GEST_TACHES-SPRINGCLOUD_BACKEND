package com.mycompany.fichierApplication.services;

import com.mycompany.fichierApplication.dto.FichierRequestDTO;
import com.mycompany.fichierApplication.dto.FichierResponseDTO;
import com.mycompany.fichierApplication.entity.Fichier;
import com.mycompany.fichierApplication.mapper.IFichierMapper;
import com.mycompany.fichierApplication.repository.IFichierRepository;

import java.util.ArrayList;
import java.util.List;

public class FichierService implements IFichierService{

    private final IFichierRepository repository;

    private final IFichierMapper mapper;

    public FichierService(IFichierRepository repository, IFichierMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FichierResponseDTO createFichier(FichierRequestDTO fichierRequestDTO) {
        if(fichierRequestDTO.getGroupeId() != null || fichierRequestDTO.getDesignation().equals("") || fichierRequestDTO.getExtension().equals("")){
            return mapper.FichierToFichierResponseDTO(repository.save(mapper.FichierRequestDTOToFichier(fichierRequestDTO)));
        }
        else{
            throw new RuntimeException("Exception : can not save - fields empty or id is not null ! ");
        }
    }

    @Override
    public List<FichierResponseDTO> loadByGroupeId(Long groupeId) {

        List<FichierResponseDTO> fichierResponseDTOS = new ArrayList<>();

        repository.findAll().forEach(res->{

            if(!res.isDeleted() && res.getGroupeId().equals(groupeId)){
                fichierResponseDTOS.add(mapper.FichierToFichierResponseDTO(res));
            }
        });

        return fichierResponseDTOS;
    }

    @Override
    public void updateFichier(Fichier fichier) {
        repository.save(fichier);
    }

    @Override
    public Fichier loadById(Long ref) {
        if(repository.findById(ref).isPresent()){
            return repository.findById(ref).get();
        }
        else{
            throw new RuntimeException("Exception : File not Find");
        }
    }

    @Override
    public String deleteFichier(Long ref) {
        Fichier fichier = loadById(ref);
        fichier.setDeleted(true);

        updateFichier(fichier);

        return "Request Success !!";
    }
}
