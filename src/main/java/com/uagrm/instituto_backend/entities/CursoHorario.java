package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "curso_horario")
public class CursoHorario {
    @Id
    public String id;

    @DBRef
    public Curso curso;

    @DBRef
    public Horario horario;
}
