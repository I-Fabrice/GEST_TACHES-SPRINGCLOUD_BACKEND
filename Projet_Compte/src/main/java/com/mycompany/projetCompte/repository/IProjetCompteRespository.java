package com.mycompany.projetCompte.repository;

import com.mycompany.projetCompte.entity.ProjetCompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProjetCompteRespository extends JpaRepository<ProjetCompte,Long> {

    List<ProjetCompte> getProjetComptesByCompteId(Long compteId);
}
