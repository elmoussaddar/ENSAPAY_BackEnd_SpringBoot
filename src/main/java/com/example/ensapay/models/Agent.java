package com.example.ensapay.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_agent;
    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @Column(name = "nom",nullable = false)
    private String nom;

    @Column(name = "prenom",nullable = false)
    private String prenom;

    @Column(name = "pieceIdentite",nullable = false)
    private String pieceIdentite;

    @Column(name = "numPieceIdentite",nullable = false)
    private String numPieceIdentite;

    @Column(name = "dateNaissance",nullable = false)
    private Date dateNaissance;

    @Column(name = "adresse",nullable = false)
    private String adresse;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="numTel",nullable = false)
    private String numTel;

    @Column(name="numMatriculation",nullable = false)
    private String numMatriculation;

    @Column(name="numPattente",nullable = false)
    private String numPattente;

    @Column(name="firstAuth",nullable = false)
    private Boolean firstAuth;

    @OneToMany(fetch = EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<UserApp> usersApp = new ArrayList<>();
    @OneToMany(fetch = EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<AgentFile> agentFiles = new ArrayList<>();

    @Column(name="role")
    private String role = "ROLE_AGENT";

    public Agent(String username, String nom, String prenom, String pieceIdentite, String numPieceIdentite, Date dateNaissance, String adresse, String email, String password, String numTel, String numMatriculation, String numPattente, Boolean firstAuth, Collection<UserApp> usersApp) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.pieceIdentite = pieceIdentite;
        this.numPieceIdentite = numPieceIdentite;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.numMatriculation = numMatriculation;
        this.numPattente = numPattente;
        this.firstAuth = firstAuth;
        this.usersApp = usersApp;
    }
}
