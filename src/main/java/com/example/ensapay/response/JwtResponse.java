package com.example.ensapay.response;


import com.example.ensapay.models.Agent;
import com.example.ensapay.models.UserApp;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String role;
    private UserApp client;
    private  Agent agent;

    private String nom;
    private String prenom;
    private String adress;
    private Date dateNaissance;

    private String idType;
    private String numId;
    private String numMatricule;
    private String numPatente;
    private String phone;
    private  String password;

    public JwtResponse(String accessToken, Long id, String username, String email, String role) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }


    public JwtResponse(String accessToken, UserApp client) {
        this.token = accessToken;
        this.client = client;
    }



    //sending Agent Details

    public JwtResponse(String accessToken, Long id, String username, String nom, String prenom, String email, String adress, Date dateNaissance, String role,
                       String idType, String numId, String numMatricule, String numPatente, String phone, String password) {
        this.token=accessToken;
        this.id=id;
        this.username=username;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.adress=adress;
        this.dateNaissance=dateNaissance;
        this.role=role;
        this.idType=idType;
        this.numPatente=numPatente;
        this.numId=numId;
        this.numMatricule=numMatricule;
        this.phone=phone;
        this.password=password;



    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String  getRoles() {
        return role;
    }
}

