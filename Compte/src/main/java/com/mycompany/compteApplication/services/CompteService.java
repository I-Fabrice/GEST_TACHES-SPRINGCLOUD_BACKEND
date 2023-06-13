package com.mycompany.compteApplication.services;

import com.mycompany.compteApplication.entity.Compte;
import com.mycompany.compteApplication.repository.ICompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompteService implements  ICompteService{
    private final ICompteRepository repository;

    public CompteService(ICompteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCompte(Compte compte) {
        repository.save(compte);
    }

    @Override
    public Compte loadById(Long ref) {
        if(repository.findById(ref).isPresent()){
            return repository.findById(ref).get();
        }
        else{
            throw  new RuntimeException("Exception : Compte not find !");
        }
    }
}
