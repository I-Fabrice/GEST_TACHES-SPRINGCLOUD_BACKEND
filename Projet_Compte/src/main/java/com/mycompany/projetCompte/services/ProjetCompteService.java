package com.mycompany.projetCompte.services;

import com.mycompany.projetCompte.dto.ProjetCompteRequestDTO;
import com.mycompany.projetCompte.dto.ProjetResponseDTO;
import com.mycompany.projetCompte.entity.ProjetCompte;
import com.mycompany.projetCompte.openfeign.IProjetRestClient;
import com.mycompany.projetCompte.repository.IProjetCompteRespository;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjetCompteService implements IProjetCompteService{

    private final IProjetCompteRespository respository;

    private final IProjetRestClient restClient;

    public ProjetCompteService(IProjetCompteRespository respository, IProjetRestClient restClient) {
        this.respository = respository;
        this.restClient = restClient;
    }

    @Override
    public ProjetResponseDTO create(ProjetCompteRequestDTO projetCompteRequestDTO) {

        ProjetCompte projet = new ProjetCompte();

        ProjetResponseDTO projetResponseDTO = restClient.create(projetCompteRequestDTO.getDesignation());

        projet.setCompteId(projetCompteRequestDTO.getCompteId());
        projet.setProjetId(projetResponseDTO.getRef());

        respository.save(projet);

        return projetResponseDTO;

    }

    @Override
    public List<ProjetResponseDTO> loadProjetsByCompte(Long compteId) {

        List<ProjetCompte> data = respository.getProjetComptesByCompteId(compteId);
        List<ProjetResponseDTO> projetResponseDTOS = new ArrayList<>();

        data.forEach(res->{
            projetResponseDTOS.add(restClient.loadProjetByRef(res.getProjetId()));
        });


        if(projetResponseDTOS.isEmpty()){
            throw new RuntimeException("Exception : none projet find");
        }else{
            return projetResponseDTOS;
        }
    }
}
