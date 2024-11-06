package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "asistencias")
public class Asistencia {
    @Id
    public String id;
    public LocalDate fecha;
    public LocalDateTime horaInicio;
    public LocalDateTime horaFinal;

    @DBRef
    public Usuario docente;

    @DBRef
    public CursoHorario cursoHorario;
}
