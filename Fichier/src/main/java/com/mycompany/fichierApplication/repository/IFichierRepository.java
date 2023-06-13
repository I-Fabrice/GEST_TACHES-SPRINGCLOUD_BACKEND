package com.mycompany.fichierApplication.repository;

import com.mycompany.fichierApplication.entity.Fichier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFichierRepository extends JpaRepository<Fichier,Long> {
}
