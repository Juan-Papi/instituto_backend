package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;


@Document(collection = "examenes")
public class Examen {
    @Id
    public String id;
    public String tema;
    public String descripcion;
    public LocalDate fecha;
    public int ponderacion;

    @DBRef
    public Curso curso;

    @DBRef
    public Usuario profesor;
}
