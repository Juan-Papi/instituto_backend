package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "asistencias")
public class Asistencia {
    @Id
    public String id;
    public Date fecha;
    public Date horaInicio;
    public Date horaFinal;

    @DBRef
    public Usuario docente;

    @DBRef
    public CursoHorario cursoHorario;
}
