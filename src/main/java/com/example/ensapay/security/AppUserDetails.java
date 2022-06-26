package com.example.ensapay.security;

import com.example.ensapay.models.Admin;
import com.example.ensapay.models.UserApp;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class AppUserDetails implements UserDetails{

    private UserApp userApp;

    public AppUserDetails(UserApp userApp) {
        super();
        this.userApp = userApp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(userApp.getRole()));
    }

    @Override
    public String getPassword() {
        return userApp.getPassword();
    }

    @Override
    public String getUsername() {
        return userApp.getUsername();
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
        AppUserDetails user = (AppUserDetails) o;
        return Objects.equals(userApp.getId_user(), user.userApp.getId_user());
    }
    public Long getId() {
        return userApp.getId_user();
    }

    public String getEmail() {
        return userApp.getEmail();
    }
}
