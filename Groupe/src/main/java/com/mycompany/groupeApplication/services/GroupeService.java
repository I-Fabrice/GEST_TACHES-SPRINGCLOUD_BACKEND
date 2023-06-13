package com.mycompany.groupeApplication.services;

import com.mycompany.groupeApplication.dto.DesignationRequestDTO;
import com.mycompany.groupeApplication.dto.GroupeRequestDTO;
import com.mycompany.groupeApplication.dto.GroupeResponseDTO;
import com.mycompany.groupeApplication.entity.Groupe;
import com.mycompany.groupeApplication.mapper.IGroupeMapper;
import com.mycompany.groupeApplication.repository.IGroupeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GroupeService implements  IGroupeService{

    private final IGroupeMapper mapper;

    private final IGroupeRepository repository;

    public GroupeService(IGroupeMapper mapper, IGroupeRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public GroupeResponseDTO create(Long projetId) {
        if(projetId == null)
            throw new RuntimeException("");
        else{
            return mapper.groupeToGroupeResponseDTO(repository.save(new Groupe(null,"Nouveau Groupe",false,projetId,null)));
        }

    }

    @Override
    public String updateGroupe(Groupe groupe) {
        if(groupe.getRef() != null){
            repository.save(groupe);
            return "Request Success !";
        }
        else{
            throw new RuntimeException("Exception: value id groupe missing !");
        }
    }

    @Override
    public String setDesignation(DesignationRequestDTO designationRequestDTO) {
        if(repository.findById(designationRequestDTO.getRef()).isPresent()){
            Groupe groupe = repository.findById(designationRequestDTO.getRef()).get();
            groupe.setDesignation(designationRequestDTO.getDesignation());

            updateGroupe(groupe);
            return designationRequestDTO.getDesignation();
        }
        else{
            throw new RuntimeException("Exception: Can't update Designation: groupe not find !");
        }
    }

    @Override
    public String deleteGroupe(Long ref) {
        if(repository.findById(ref).isPresent()){
            Groupe groupe = repository.findById(ref).get();
            groupe.setDeleted(true);

            repository.save(groupe);
            return "Request Success !";
        }
        else{
            throw new RuntimeException("Exception: Can't delete, groupe not find !");
        }
    }

    @Override
    public Groupe loadById(Long ref) {
        if(repository.findById(ref).isPresent()){
            return  repository.findById(ref).get();
        }
        else{
            throw new RuntimeException("Exception : Can't find Groupe");
        }
    }

    @Override
    public List<GroupeResponseDTO> loadGroupesByprojetId(Long projetId) {
        List<GroupeResponseDTO> groupeResponseDTOS = new ArrayList<>();

        repository.getGroupesByProjetId(projetId).forEach(groupe->{
            if(!groupe.isDeleted()){
                groupeResponseDTOS.add(mapper.groupeToGroupeResponseDTO(groupe));
            }

        });

        return groupeResponseDTOS;
    }
}
