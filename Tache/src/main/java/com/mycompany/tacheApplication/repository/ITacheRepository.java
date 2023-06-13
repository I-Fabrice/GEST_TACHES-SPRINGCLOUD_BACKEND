package com.mycompany.tacheApplication.repository;

import com.mycompany.tacheApplication.entity.Tache;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITacheRepository extends JpaRepository<Tache, Long> {

    List<Tache> getTachesByGroupeId(Long groupeId);

    Tache getTacheByStatutId(Long statutId);

}
