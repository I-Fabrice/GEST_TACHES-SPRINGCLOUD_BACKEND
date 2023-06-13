package com.mycompany.compteApplication.services;

import com.mycompany.compteApplication.entity.Compte;

public interface ICompteService {

    void createCompte(Compte compte);
    Compte loadById(Long ref);
}
