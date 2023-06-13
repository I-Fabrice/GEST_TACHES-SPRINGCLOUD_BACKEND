package com.mycompany.compteApplication.repository;

import com.mycompany.compteApplication.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteRepository extends JpaRepository<Compte, Long> {

}
