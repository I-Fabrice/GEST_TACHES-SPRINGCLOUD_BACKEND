package com.mycompany.projetApplication.repository;

import com.mycompany.projetApplication.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjetRepository extends JpaRepository<Projet, Long> {
}
