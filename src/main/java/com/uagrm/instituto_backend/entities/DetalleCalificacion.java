package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detalle_calificacion")
public class DetalleCalificacion {
    @Id
    public String id;
    public float calificacion;

    @DBRef
    public CalificacionCurso calificacionCurso;

    @DBRef
    public Usuario estudiante;
}
