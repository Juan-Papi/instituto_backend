package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "calificaciones")
public class Calificacion {
    @Id
    public String id;
    public int nota;

    @DBRef
    public Usuario estudiante;

    @DBRef
    public Examen examen;
}
