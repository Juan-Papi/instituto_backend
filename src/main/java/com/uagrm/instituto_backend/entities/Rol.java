package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document(collection = "roles")
public class Rol {
    @Id
    public String id;
    public String nombre; // Ejemplo: "ADMIN", "USER"
    public Set<Permiso> permisos;
}