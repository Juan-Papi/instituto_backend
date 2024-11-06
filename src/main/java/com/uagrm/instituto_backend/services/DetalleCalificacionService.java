package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.CalificacionCurso;
import com.uagrm.instituto_backend.entities.DetalleCalificacion;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.CalificacionCursoRepository;
import com.uagrm.instituto_backend.repositories.DetalleCalificacionRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCalificacionService {

    @Autowired
    private DetalleCalificacionRepository detalleCalificacionRepository;

    @Autowired
    private CalificacionCursoRepository calificacionCursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DetalleCalificacion crearDetalleCalificacion(float calificacion, String calificacionCursoId, String estudianteId) {
        CalificacionCurso calificacionCurso = calificacionCursoRepository.findById(calificacionCursoId)
                .orElseThrow(() -> new RuntimeException("Calificación de curso no encontrada"));
        Usuario estudiante = usuarioRepository.findById(new ObjectId(estudianteId))
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        DetalleCalificacion detalle = new DetalleCalificacion();
        detalle.calificacion = calificacion;
        detalle.calificacionCurso = calificacionCurso;
        detalle.estudiante = estudiante;

        return detalleCalificacionRepository.save(detalle);
    }

    public List<DetalleCalificacion> obtenerDetallesCalificacion() {
        return detalleCalificacionRepository.findAll();
    }

    public DetalleCalificacion obtenerDetalleCalificacionPorId(String id) {
        return detalleCalificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de calificación no encontrado"));
    }
}

