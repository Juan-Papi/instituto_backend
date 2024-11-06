package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "boleta_inscripcion")
public class BoletaInscripcion {
    @Id
    public String id;
    public LocalDate fecha;
    public float montoTotal;

    @DBRef
    public Usuario administrador;

    @DBRef
    public Usuario estudiante;
}
