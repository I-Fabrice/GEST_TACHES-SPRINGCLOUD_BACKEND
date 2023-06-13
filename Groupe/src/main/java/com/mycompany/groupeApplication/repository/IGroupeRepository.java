package com.mycompany.groupeApplication.repository;

import com.mycompany.groupeApplication.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGroupeRepository extends JpaRepository<Groupe, Long> {
    List<Groupe> getGroupesByProjetId(Long projetId);

    Groupe getGroupeByProjetId(Long projetId);
}
