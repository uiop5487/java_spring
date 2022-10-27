package com.demo.demo.core.auth;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication {
    
    private String useremail;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean authenticatied;

    public UserAuthentication(
        String useremail,
        Collection<? extends GrantedAuthority> authorities,
        boolean authenticatied
    ) {
        this.useremail = useremail;
        this.authorities = authorities;
        this.authenticatied = authenticatied;
    }

    @Override
    public String getName() {
        return useremail;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticatied;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticatied = isAuthenticated;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
}
