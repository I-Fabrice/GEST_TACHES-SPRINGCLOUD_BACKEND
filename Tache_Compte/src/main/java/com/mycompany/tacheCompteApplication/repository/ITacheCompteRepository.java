package com.mycompany.tacheCompteApplication.repository;

import com.mycompany.tacheCompteApplication.entity.TacheCompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITacheCompteRepository extends JpaRepository<TacheCompte,Long> {
    List<TacheCompte> findTacheComptesByCompteId(Long compteId);

    List<TacheCompte> findTacheComptesByTacheId(Long tacheId);

    List<TacheCompte> deleteTacheComptesByTacheId(Long tacheId);
}
