package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document(collection = "usuarios")
public class Usuario {
    @Id
    public String id;
    public String username;
    public String password;
    public Set<Rol> roles;
}