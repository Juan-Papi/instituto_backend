package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Asistencia;
import com.uagrm.instituto_backend.entities.DetalleAsistencia;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.AsistenciaRepository;
import com.uagrm.instituto_backend.repositories.DetalleAsistenciaRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class DetalleAsistenciaService {

    @Autowired
    private DetalleAsistenciaRepository detalleAsistenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public DetalleAsistencia crearDetalleAsistencia(String hora, String estudianteId, String asistenciaId) {
        Usuario estudiante = usuarioRepository.findById(new ObjectId(estudianteId)).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Asistencia asistencia = asistenciaRepository.findById(asistenciaId).orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));

        DetalleAsistencia detalle = new DetalleAsistencia();
        detalle.hora = LocalDateTime.parse(hora);
        detalle.estudiante = estudiante;
        detalle.asistencia = asistencia;

        return detalleAsistenciaRepository.save(detalle);
    }

    public List<DetalleAsistencia> obtenerDetallesAsistencia() {
        return detalleAsistenciaRepository.findAll();
    }

    public DetalleAsistencia obtenerDetalleAsistenciaPorId(String id) {
        return detalleAsistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de asistencia no encontrado"));
    }
}
