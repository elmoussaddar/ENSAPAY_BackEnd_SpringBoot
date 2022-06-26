package com.example.ensapay.request;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

public class SignupRequestAgent {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;



    @NotBlank
    @Size(min = 2, max = 40)
    private String password;

    @NotBlank
    @Size(min = 2, max = 40)
    private String  nom;
    @NotBlank
    @Size(min = 2, max = 40)
    private String  prenom;
    @NotBlank
    @Size(min = 2, max = 40)
    private String  pieceIdentite;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  numPieceIdentite;
    @NotBlank

        private Date dateNaissance;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  adresse;
    @NotBlank
    @Size(min = 2, max = 40)

    private String  numTel;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  numMatriculation;
    @NotBlank
    @Size(min = 2, max = 240)
    private String  numPattente;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setPassword(String password) {
        this.password = password;
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

    public String getPieceIdentite() {
        return pieceIdentite;
    }

    public void setPieceIdentite(String pieceIdentite) {
        this.pieceIdentite = pieceIdentite;
    }

    public String getNumPieceIdentite() {
        return numPieceIdentite;
    }

    public void setNumPieceIdentite(String numPieceIdentite) {
        this.numPieceIdentite = numPieceIdentite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNumMatriculation() {
        return numMatriculation;
    }

    public void setNumMatriculation(String numMatriculation) {
        this.numMatriculation = numMatriculation;
    }

    public String getNumPattente() {
        return numPattente;
    }

    public void setNumPattente(String numPattente) {
        this.numPattente = numPattente;
    }
}
