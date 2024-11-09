package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.BoletaInscripcion;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.BoletaInscripcionRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BoletaInscripcionService {

    @Autowired
    private BoletaInscripcionRepository boletaInscripcionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public BoletaInscripcion crearBoletaInscripcion(String fecha, float montoTotal, String administradorId, String estudianteId) {
        Usuario administrador = usuarioRepository.findById(new ObjectId(administradorId))
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        Usuario estudiante = usuarioRepository.findById(new ObjectId(estudianteId))
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        BoletaInscripcion boleta = new BoletaInscripcion();
        boleta.fecha = LocalDate.parse(fecha); // Conversión de String a LocalDate
        boleta.montoTotal = montoTotal;
        boleta.administrador = administrador;
        boleta.estudiante = estudiante;

        return boletaInscripcionRepository.save(boleta);
    }

    public List<BoletaInscripcion> obtenerBoletasInscripcion() {
        return boletaInscripcionRepository.findAll();
    }

    public BoletaInscripcion obtenerBoletaInscripcionPorId(String id) {
        return boletaInscripcionRepository.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Boleta no encontrada"));
    }
}

