package com.example.ensapay.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Transactional
@NoArgsConstructor
@Table
@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_compte;

    @Column(name="comptename",nullable = false)
    private String comptename="Checking Account";

    @Column(name="rib",nullable = false)
    private String rib;

    @Column(name="solde",nullable = true)
    private Double solde;

    @Column(name="type_compte")
    private String type_compte;



    public String getComptename() {
        return comptename;
    }

    public void setComptename(String comptename) {
        this.comptename = comptename;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getType_compte() {
        return type_compte;
    }

    public void setType_compte(String type_compte) {
        this.type_compte = type_compte;
    }




}