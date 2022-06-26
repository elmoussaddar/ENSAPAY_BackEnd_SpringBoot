package com.example.ensapay.security;

import com.example.ensapay.models.Agent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

public class AppAgentDetails implements UserDetails{




    private Agent agent;

    public AppAgentDetails(Agent agent) {
        super();
        this.agent = agent;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(agent.getRole()));
    }

    @Override
    public String getPassword() {
        return agent.getPassword();
    }

    @Override
    public String getUsername() {
        return agent.getUsername();
    }


    public String getIdType() {
        return agent.getPieceIdentite();
    }

    public String getAdress() {
        return agent.getAdresse();
    }
    public String getPhone() {
        return agent.getNumTel();
    }
    public String getNumMatricule() {
        return agent.getNumMatriculation();
    }
    public String getNumId() {
        return agent.getNumPieceIdentite();
    }
    public String getNumPatente() {
        return agent.getNumPattente();
    }
    public String getNom() {
        return agent.getNom();
    }
    public String getPrenom() {
        return agent.getPrenom();
    }
    public Date getDateNaissance() {
        return agent.getDateNaissance();
    }
    public Boolean getFirstAuth() {
        return agent.getFirstAuth();
    }





    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AppAgentDetails user = (AppAgentDetails) o;
        return Objects.equals(agent.getId_agent(), user.agent.getId_agent());
    }
    public Long getId() {
        return agent.getId_agent();
    }

    public String getEmail() {
        return agent.getEmail();
    }
}