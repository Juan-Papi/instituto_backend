package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "cursos")
public class Curso {
    @Id
    public String id;
    public String nombre;
    public String descripcion;
    public LocalDate fechaInicio;
    public LocalDate fechaFinal;
    public float precio;

    @DBRef
    public Usuario profesor;
}
