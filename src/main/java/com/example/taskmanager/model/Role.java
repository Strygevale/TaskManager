package com.example.taskmanager.model;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER, ADMIN;

    /*@Override
    public String getAuthority(){
        return name();
    }*/
}
