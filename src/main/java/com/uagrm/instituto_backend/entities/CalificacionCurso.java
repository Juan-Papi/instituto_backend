package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "calificacion_curso")
public class CalificacionCurso {
    @Id
    public String id;
    public Date fecha;
    public Date hora;

    @DBRef
    public Curso curso;
}
