package com.example.ensapay.repository;

import com.example.ensapay.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepo extends JpaRepository<Facture,Long> {
    Facture findByCreancier(String creancier);
    Facture findByRef(String ref);
}
