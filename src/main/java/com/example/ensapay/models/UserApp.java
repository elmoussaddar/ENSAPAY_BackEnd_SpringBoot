package com.example.ensapay.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor

@Table
@Entity
public class UserApp {


        //en milliseconde
        private static final long PASSWORD_EXPIRATION_TIME
                = 30L * 24L * 60L * 60L * 1000L;


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id_user;
        @Column(name = "username",unique = true,nullable = false,updatable = false)
        private String username;
        @Column(name = "nom",nullable = false)
        private String nom;

        @Column(name = "prenom",nullable = false)
        private String prenom;

        @Column(name = "numTel",nullable = false)
        private  String numTel;


        @Column(name = "email",unique = true,nullable = false)
        private String email;

        @Column(name="password",nullable = false)
        private String password;


    @Column(name="firstAuth",nullable = false)
    private Boolean firstAuth = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_compte")
    private Compte compte;

    @Column(name="role")
    private String role = "ROLE_CLIENT";



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFirstAuth() {
        return firstAuth;
    }

    public void setFirstAuth(Boolean firstAuth) {
        this.firstAuth = firstAuth;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




    public UserApp(String nom, String prenom,String email, String numTel, String password, Boolean firstAuth, Compte compte) {
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.email = email;
        this.password = password;
        this.firstAuth = firstAuth;
        this.compte = compte;
    }

/*@Column(name = "password_changed_time")
        private Date passwordChangedTime;*/

        /*@Column(name = "profil")
        private String profil;*/

        /*@Column(name = "cinRecto")
        private byte[] cinRecto;

        @Column(name = "cinVerso")
        private byte[] cinVerso;*/



        /*@Column(name = "isBlacklisted")
        private Boolean isBlacklisted;*/

        // @JsonIgnore
        // @OneToMany(mappedBy="client",  cascade = CascadeType.ALL)
        // private Collection<ComptePayement> comptePayements;
        /*@OneToOne(mappedBy="client",cascade = CascadeType.ALL)
        private ComptePayement comptePayements;*/

        /*public UserApp(String nom, String prenom, String numTel, Date passwordChangedTime, String password, String profil, String username, byte[] cinRecto, byte[] cinVerso) {
            this.nom = nom;
            this.prenom = prenom;
            this.numTel = numTel;
            this.passwordChangedTime = passwordChangedTime;
            this.password = password;
            this.profil = profil;
            this.username = username;
            this.cinRecto = cinRecto;
            this.cinVerso = cinVerso;
        }*/


    }


