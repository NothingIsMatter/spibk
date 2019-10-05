package com.spibook.core.entity;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
  ROLE_USER,ADMIN;
    @Override
    public String getAuthority() {
        return this.name();
    }
}

