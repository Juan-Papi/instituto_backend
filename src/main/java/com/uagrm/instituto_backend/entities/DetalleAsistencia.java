package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "detalle_asistencia")
public class DetalleAsistencia {
    @Id
    public String id;
    public Date hora;

    @DBRef
    public Usuario estudiante;

    @DBRef
    public Asistencia asistencia;
}

