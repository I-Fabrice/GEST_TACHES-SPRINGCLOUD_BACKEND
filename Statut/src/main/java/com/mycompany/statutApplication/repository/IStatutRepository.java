package com.mycompany.statutApplication.repository;

import com.mycompany.statutApplication.entity.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatutRepository extends JpaRepository<Statut,Long> {
    Statut getStatutByDesignation(String designation);
}
