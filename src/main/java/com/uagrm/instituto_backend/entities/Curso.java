package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "cursos")
public class Curso {
    @Id
    public String id;
    public String nombre;
    public String descripcion;
    public Date fechaInicio;
    public Date fechaFinal;
    public float precio;

    @DBRef
    public Usuario profesor;
}
