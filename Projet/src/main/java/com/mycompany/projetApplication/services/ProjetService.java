package com.mycompany.projetApplication.services;

import com.mycompany.projetApplication.dto.DesignationRequestDTO;
import com.mycompany.projetApplication.dto.ProjetResponseDTO;
import com.mycompany.projetApplication.entity.Projet;
import com.mycompany.projetApplication.mapper.IProjetMapper;
import com.mycompany.projetApplication.repository.IProjetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjetService implements IProjetService{

    private final IProjetMapper mapper;

    private final IProjetRepository repository;

    public ProjetService(IProjetMapper mapper, IProjetRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ProjetResponseDTO create(String designation) {
        return mapper.projetToProjetResponseDTO(repository.save(new Projet(null,designation,false)));
    }

    @Override
    public String updateProjet(Projet projet) {
        if(projet.getRef() != null){
            repository.save(projet);
            return "Request Success !";
        }
        else{
            throw new RuntimeException("Exception: value id project missing !");
        }
    }

    @Override
    public String setDesignation(DesignationRequestDTO designationRequestDTO) {
        if(repository.findById(designationRequestDTO.getRef()).isPresent()){
            Projet projet = repository.findById(designationRequestDTO.getRef()).get();
            projet.setDesignation(designationRequestDTO.getDesignation());

            updateProjet(projet);
            return designationRequestDTO.getDesignation();
        }
        else{
            throw new RuntimeException("Exception: Can't update Designation: Project not find !");
        }
    }

    @Override
    public String deleteProjet(Long ref) {
        if(repository.findById(ref).isPresent()){
            Projet projet = repository.findById(ref).get();
            projet.setDeleted(true);

            repository.save(projet);
            return "Request Success !";
        }
        else{
            throw new RuntimeException("Exception: Can't delete, project not find !");
        }
    }

    @Override
    public ProjetResponseDTO loadProjetByRef(Long ref) {
        if(!repository.findById(ref).isPresent() || repository.findById(ref).get().isDeleted()){
            throw new RuntimeException("Exception : projet not find !");
        }
        else{
            return mapper.projetToProjetResponseDTO(repository.findById(ref).get());
        }
    }
}
