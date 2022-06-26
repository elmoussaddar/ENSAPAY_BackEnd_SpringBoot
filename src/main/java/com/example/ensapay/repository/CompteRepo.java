package com.example.ensapay.repository;

import com.example.ensapay.models.Compte;
import com.example.ensapay.models.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepo extends JpaRepository<Compte, Long> {
    Compte findByRib(String rib);
}