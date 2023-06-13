package com.mycompany.statutApplication.services;

import com.mycompany.statutApplication.dto.DesignationRequestDTO;
import com.mycompany.statutApplication.dto.StatutResponseDTO;
import com.mycompany.statutApplication.entity.Statut;
import com.mycompany.statutApplication.mapper.IStatutMapper;
import com.mycompany.statutApplication.repository.IStatutRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StatutService implements IStatutService {
    private final IStatutRepository repository;

    private final IStatutMapper mapper;

    public StatutService(IStatutRepository repository, IStatutMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(Statut statut) {
        repository.save(statut);
    }

    @Override
    public String updateStatut(DesignationRequestDTO designationRequestDTO) {
        if(designationRequestDTO.getRef() != null || designationRequestDTO.getDesignation().equals("")){
            repository.save(loadById(designationRequestDTO.getRef()));
            return "Request Success !";
        }else{
            throw new RuntimeException("Exception : field(s) emmpty !");
        }

    }

    @Override
    public StatutResponseDTO loadStatutById(Long ref) {
        return mapper.statutToStatutResponseDTO(loadById(ref));
    }

    @Override
    public Statut loadById(Long ref) {
        if(!repository.findById(ref).isPresent() || repository.findById(ref).get().isDeleted()){
            throw new RuntimeException("Exception : Can not find Statut !");
        }else{
            return repository.findById(ref).get();
        }
    }

    @Override
    public Statut loadByDesignation(String designation) {
        if(designation.equals("")){
            throw new RuntimeException("Exception : value not be empty");
        }
        else{
            return repository.getStatutByDesignation(designation);
        }
    }
}
