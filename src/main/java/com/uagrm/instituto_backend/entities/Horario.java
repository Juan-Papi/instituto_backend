package com.uagrm.instituto_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "horarios")
public class Horario {
    @Id
    public String id;
    public String dia;
    public LocalDateTime horaInicio;
    public LocalDateTime horaFinal;
}
