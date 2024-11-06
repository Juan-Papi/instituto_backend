package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "detalle_asistencia")
public class DetalleAsistencia {
    @Id
    public String id;
    public LocalDateTime hora;

    @DBRef
    public Usuario estudiante;

    @DBRef
    public Asistencia asistencia;
}

