package com.mycompany.tacheCompteApplication.services;

import com.mycompany.tacheCompteApplication.dto.CompteResponseDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteRequestDTO;
import com.mycompany.tacheCompteApplication.dto.TacheCompteResponseDTO;
import com.mycompany.tacheCompteApplication.entity.TacheCompte;
import com.mycompany.tacheCompteApplication.mapper.ITacheCompteMapper;
import com.mycompany.tacheCompteApplication.opeinfeign.ITacheCompteRestClient;
import com.mycompany.tacheCompteApplication.repository.ITacheCompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@Transactional
public class TacheCompteService implements ITacheCompteService{
    private final ITacheCompteRepository repository;

    private final ITacheCompteRestClient restClient;
    private final ITacheCompteMapper mapper;

    public TacheCompteService(ITacheCompteRepository repository, ITacheCompteRestClient restClient, ITacheCompteMapper mapper) {
        this.repository = repository;
        this.restClient = restClient;
        this.mapper = mapper;
    }

    @Override
    public String create(List<TacheCompteRequestDTO> tacheCompteRequestDTO) {

        for (int i=0;i<tacheCompteRequestDTO.size();i++){
            repository.deleteTacheComptesByTacheId(tacheCompteRequestDTO.get(i).getTacheId());
            i=tacheCompteRequestDTO.size();
        }

        tacheCompteRequestDTO.forEach(data->{
            if(data.getCompteId() == null || data.getTacheId() == null){
                throw new RuntimeException("CompteId or TacheId is null");
            }
            else{
                repository.save(mapper.TacheCompteRequestDTOToTacheCompte(data));
            }
        });

        return "Request Successful";

    }

    @Override
    public List<TacheCompteResponseDTO> getAllTacheCompteByCompteId(Long compteId) {

        List<TacheCompteResponseDTO> data = repository.findTacheComptesByCompteId(compteId).stream().map(mapper::TacheCompteToTacheCompteResponseDTO).collect(Collectors.toList());

        if(data.isEmpty()){
            throw new RuntimeException("Task for this compte Not find");
        }
        else{
            return data;
        }
    }

    @Override
    public List<CompteResponseDTO> getAllTacheCompteByTacheId(Long tacheId) {
        List<TacheCompte> datas = repository.findTacheComptesByTacheId(tacheId);
        List<CompteResponseDTO> compteResponseDTOS = new ArrayList<>();

        if(datas.isEmpty()){
            return null;
        }
        else {
            datas.forEach(data -> {
                compteResponseDTOS.add(mapper.CompteToCompteResponseDTO(restClient.loadCompteById(data.getCompteId())));
            });
            return compteResponseDTOS;
        }
    }
}
