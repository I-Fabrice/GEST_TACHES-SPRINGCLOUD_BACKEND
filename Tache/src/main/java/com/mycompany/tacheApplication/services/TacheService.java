package com.mycompany.tacheApplication.services;

import com.mycompany.tacheApplication.dto.*;
import com.mycompany.tacheApplication.entity.Statut;
import com.mycompany.tacheApplication.entity.Tache;
import com.mycompany.tacheApplication.mapper.ITacheMapper;
import com.mycompany.tacheApplication.openfeign.IStatutRestClient;
import com.mycompany.tacheApplication.openfeign.ITacheCompteRestClient;
import com.mycompany.tacheApplication.repository.ITacheRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TacheService implements ITacheService {


    private final ITacheRepository repository;
    private final IStatutRestClient restClient;

    private final ITacheCompteRestClient tacheRestClient;
    private final ITacheMapper mapper;

    public TacheService(ITacheRepository repository, IStatutRestClient restClient, ITacheCompteRestClient tacheRestClient, ITacheMapper mapper) {
        this.repository = repository;
        this.restClient = restClient;
        this.tacheRestClient = tacheRestClient;
        this.mapper = mapper;
    }

    @Override
    public TacheResponseDTO createTache(Long groupeId) {

        Tache tache = new Tache();
        TacheResponseDTO tacheResponseDTO = new TacheResponseDTO();

        StatutResponseDTO statutResponseDTO = restClient.loadStatutById(4L);

        tache.setDesignation("Nouvelle Tache");
        tache.setGroupeId(groupeId);
        tache.setStatutId(statutResponseDTO.getRef());

        tache.setStatut(mapper.statutResponseDTOToStatut(statutResponseDTO));

        Tache data = repository.save(tache);

        tacheResponseDTO.setRef(data.getRef());
        tacheResponseDTO.setDesignation(data.getDesignation());

        tacheResponseDTO.setStatutResponseDTO(statutResponseDTO);

        return tacheResponseDTO;
    }

    @Override
    public String deleteTache(Long ref) {
        if(repository.findById(ref).isPresent()){
            Tache tache = repository.findById(ref).get();
            tache.setDeleted(true);

            repository.save(tache);
            return "Request Success !";
        }
        else{
            throw new RuntimeException("Exception: Can't delete task not find !");
        }
    }

    @Override
    public String update(Tache tache) {
        if(tache.getRef() != null){

            repository.save(tache);
            return "Request Success !";
        }
        else{
            throw new RuntimeException("Exception: value id Task missing !");
        }
    }

    @Override
    public String editTache(TacheRequestDTO tacheRequestDTO) {
        List<TacheCompteRequestDTO> list = new ArrayList<>();

        if(!repository.findById(tacheRequestDTO.getRef()).isPresent() || repository.findById(tacheRequestDTO.getRef()).get().isDeleted())
            throw  new RuntimeException("Exception : tache not find or deleted");
        else{
            Tache tache = repository.findById(tacheRequestDTO.getRef()).get();
            Tache data = mapper.tacheRequestDTOToTache(tacheRequestDTO);

            //

            data.setDesignation(tache.getDesignation());

            // A REVOIR !!!!!


            data.setGroupeId(tache.getGroupeId());
            data.setStatutId(tache.getStatutId());

            data.setStatut(tache.getStatut());

            if(tacheRequestDTO.getCompteId() != null){
                tacheRequestDTO.getCompteId().forEach(item->{
                    list.add(new TacheCompteRequestDTO(tacheRequestDTO.getRef(), item.getCompteId()));
                });
                tacheRestClient.create(list);
            }



            repository.save(data);

            return "Success !";
        }

    }

    @Override
    public List<TacheResponseDTO> loadTacheByGroupeId(Long groupeId) {
        List<TacheResponseDTO> data = new ArrayList<>();


        repository.findAll().forEach(tache ->
        {
            if(!tache.isDeleted() && tache.getGroupeId() != groupeId){

                StatutResponseDTO statutResponseDTO = restClient.loadStatutById(tache.getStatutId());

                TacheResponseDTO tacheResponseDTO = mapper.tacheToTacheResponseDTO(tache);
                tacheResponseDTO.setStatutResponseDTO(statutResponseDTO);

                data.add(tacheResponseDTO);

            }
        });

        if(data.isEmpty()){
            throw new RuntimeException("Exception : Data not find for this Id ");
        }
        else{
            return data;
        }
    }

    @Override
    public TacheResponseDTO2 loadTacheByRef(Long ref) {
        if(!repository.findById(ref).isPresent() || repository.findById(ref).get().isDeleted()){
            throw new RuntimeException("Exception : this Task probably has deleted !");
        }
        else{
            return mapper.tacheToTacheResponseDTO2(repository.findById(ref).get());
        }

    }

    @Override
    public String setDesignation(DesignationRequestDTO designationRequestDTO) {

        if(repository.findById(designationRequestDTO.getRef()).isPresent()){
            Tache tache = repository.findById(designationRequestDTO.getRef()).get();
            tache.setDesignation(designationRequestDTO.getDesignation());

            // repository.save(tache);
            update(tache);
            return designationRequestDTO.getDesignation();
        }
        else{
            throw new RuntimeException("Exception: Can't update Designation: Task not find !");
        }
    }

    // @Override
    public String setDescription(DescriptionRequestDTO descriptionRequestDTO) {
        if(repository.findById(descriptionRequestDTO.getRef()).isPresent()){
            Tache tache = repository.findById(descriptionRequestDTO.getRef()).get();
            tache.setDescription(descriptionRequestDTO.getDescription());

            update(tache);
            return descriptionRequestDTO.getDescription();
        }
        else{
            throw new RuntimeException("Exception: Can't update Description: Task not find !");
        }
    }

    // @Override
    public Date setDelai(DelaiRequestDTO delaiRequestDTO) {
        if(repository.findById(delaiRequestDTO.getRef()).isPresent()){
            Tache tache = repository.findById(delaiRequestDTO.getRef()).get();
            tache.setDelai(delaiRequestDTO.getDelai());

            // repository.save(tache);
            update(tache);
            return delaiRequestDTO.getDelai();
        }
        else{
            throw new RuntimeException("Exception: Can't update Delai: Task not find !");
        }
    }

    @Override
    public String setStatut(StatutRequestDTO statutRequestDTO) {

        if(repository.findById(statutRequestDTO.getRef()).isPresent()){
            Tache tache = repository.findById(statutRequestDTO.getRef()).get();

            Statut statut = restClient.loadByDesignation(statutRequestDTO.getDesignation());

            if(statut == null){
                throw new RuntimeException("Exception : Data not Find !");
            }
            else{
                tache.setStatutId(statut.getRef());

                repository.save(tache);

                return statutRequestDTO.getDesignation();
            }
        }else{
            throw new RuntimeException("Exception : tache not find ! ");
        }


    }

    @Override
    public EditResponseDTO getTache(Long ref) {
        if(!repository.findById(ref).isPresent() || repository.findById(ref).get().isDeleted()){
            throw new RuntimeException("Exception : this Task probably has deleted !");
        }
        else{
            Tache tache = repository.findById(ref).get();

            EditResponseDTO data = mapper.TacheToEditResponseDTO(tache);
            data.setCompteResponseDTOS(tacheRestClient.getAllTacheCompteByTacheId(tache.getRef()));

            return data;
        }
    }

    @Override
    public List<TacheResponseDTO> loadAlltache() {
        List<TacheResponseDTO> data = new ArrayList<>();


        repository.findAll().forEach(tache ->
        {
            if(!tache.isDeleted()){

                StatutResponseDTO statutResponseDTO = restClient.loadStatutById(tache.getStatutId());

                TacheResponseDTO tacheResponseDTO = mapper.tacheToTacheResponseDTO(tache);
                tacheResponseDTO.setStatutResponseDTO(statutResponseDTO);

                data.add(tacheResponseDTO);

            }
        });

        return data;

    }

}
