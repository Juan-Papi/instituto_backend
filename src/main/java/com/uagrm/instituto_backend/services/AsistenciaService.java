package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Asistencia;
import com.uagrm.instituto_backend.entities.CursoHorario;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.AsistenciaRepository;
import com.uagrm.instituto_backend.repositories.CursoHorarioRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoHorarioRepository cursoHorarioRepository;

    public Asistencia crearAsistencia(String fecha, String horaInicio, String horaFinal, String docenteId, String cursoHorarioId) {
        Usuario docente = usuarioRepository.findById(new ObjectId(docenteId)).orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        CursoHorario cursoHorario = cursoHorarioRepository.findById(cursoHorarioId).orElseThrow(() -> new RuntimeException("CursoHorario no encontrado"));

        Asistencia asistencia = new Asistencia();
        asistencia.fecha = LocalDate.parse(fecha);
        asistencia.horaInicio = LocalDateTime.parse(horaInicio);
        asistencia.horaFinal = LocalDateTime.parse(horaFinal);
        asistencia.docente = docente;
        asistencia.cursoHorario = cursoHorario;

        return asistenciaRepository.save(asistencia);
    }

    public List<Asistencia> obtenerAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Asistencia obtenerAsistenciaPorId(String id) {
        return asistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));
    }
}
