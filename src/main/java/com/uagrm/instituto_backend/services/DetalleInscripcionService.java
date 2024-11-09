package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.BoletaInscripcion;
import com.uagrm.instituto_backend.entities.Curso;
import com.uagrm.instituto_backend.entities.DetalleInscripcion;
import com.uagrm.instituto_backend.repositories.BoletaInscripcionRepository;
import com.uagrm.instituto_backend.repositories.CursoRepository;
import com.uagrm.instituto_backend.repositories.DetalleInscripcionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleInscripcionService {

    @Autowired
    private DetalleInscripcionRepository detalleInscripcionRepository;

    @Autowired
    private BoletaInscripcionRepository boletaInscripcionRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public DetalleInscripcion crearDetalleInscripcion(String boletaInscripcionId, String cursoId) {
        BoletaInscripcion boletaInscripcion = boletaInscripcionRepository.findById(new ObjectId(boletaInscripcionId))
                .orElseThrow(() -> new RuntimeException("Boleta de inscripción no encontrada"));
        Curso curso = cursoRepository.findById(new ObjectId(cursoId))
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        DetalleInscripcion detalle = new DetalleInscripcion();
        detalle.boletaInscripcion = boletaInscripcion;
        detalle.curso = curso;

        return detalleInscripcionRepository.save(detalle);
    }

    public List<DetalleInscripcion> obtenerDetallesInscripcion() {
        return detalleInscripcionRepository.findAll();
    }

    public DetalleInscripcion obtenerDetalleInscripcionPorId(String id) {
        return detalleInscripcionRepository.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Detalle de inscripción no encontrado"));
    }
}
