package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.CalificacionCurso;
import com.uagrm.instituto_backend.entities.Curso;
import com.uagrm.instituto_backend.repositories.CalificacionCursoRepository;
import com.uagrm.instituto_backend.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CalificacionCursoService {

    @Autowired
    private CalificacionCursoRepository calificacionCursoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public CalificacionCurso crearCalificacionCurso(Date fecha, Date hora, String cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        CalificacionCurso calificacionCurso = new CalificacionCurso();
        calificacionCurso.fecha = fecha;
        calificacionCurso.hora = hora;
        calificacionCurso.curso = curso;

        return calificacionCursoRepository.save(calificacionCurso);
    }

    public List<CalificacionCurso> obtenerCalificacionesCurso() {
        return calificacionCursoRepository.findAll();
    }

    public CalificacionCurso obtenerCalificacionCursoPorId(String id) {
        return calificacionCursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Calificación de curso no encontrada"));
    }
}

