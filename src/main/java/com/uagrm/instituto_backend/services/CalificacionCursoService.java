package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.CalificacionCurso;
import com.uagrm.instituto_backend.entities.Curso;
import com.uagrm.instituto_backend.repositories.CalificacionCursoRepository;
import com.uagrm.instituto_backend.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CalificacionCursoService {

    @Autowired
    private CalificacionCursoRepository calificacionCursoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public CalificacionCurso crearCalificacionCurso(String fecha, String hora, String cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        CalificacionCurso calificacionCurso = new CalificacionCurso();
        calificacionCurso.fecha = LocalDate.parse(fecha);
        calificacionCurso.hora = LocalDateTime.parse(hora);
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

