package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "permisos")
public class Permiso {
    @Id
    public String id;
    public String nombre; // Ejemplo: "READ_USERS", "CREATE_USERS"
}