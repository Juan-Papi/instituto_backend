package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Calificacion;
import com.uagrm.instituto_backend.entities.Examen;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.CalificacionRepository;
import com.uagrm.instituto_backend.repositories.ExamenRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ExamenRepository examenRepository;

    public Calificacion crearCalificacion(int nota, String estudianteId, String examenId) {
        Usuario estudiante = usuarioRepository.findById(new ObjectId(estudianteId)).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Examen examen = examenRepository.findById(new ObjectId(examenId)).orElseThrow(() -> new RuntimeException("Examen no encontrado"));

        Calificacion calificacion = new Calificacion();
        calificacion.nota = nota;
        calificacion.estudiante = estudiante;
        calificacion.examen = examen;

        return calificacionRepository.save(calificacion);
    }

    public List<Calificacion> obtenerCalificaciones() {
        return calificacionRepository.findAll();
    }

    public Calificacion obtenerCalificacionPorId(String id) {
        return calificacionRepository.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
    }
}
