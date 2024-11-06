package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detalle_inscripcion")
public class DetalleInscripcion {
    @Id
    public String id;

    @DBRef
    public BoletaInscripcion boletaInscripcion;

    @DBRef
    public Curso curso;
}
