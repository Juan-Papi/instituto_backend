package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Curso;
import com.uagrm.instituto_backend.entities.CursoHorario;
import com.uagrm.instituto_backend.entities.Horario;
import com.uagrm.instituto_backend.repositories.CursoHorarioRepository;
import com.uagrm.instituto_backend.repositories.CursoRepository;
import com.uagrm.instituto_backend.repositories.HorarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoHorarioService {

    @Autowired
    private CursoHorarioRepository cursoHorarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    public CursoHorario crearCursoHorario(String cursoId, String horarioId) {
        Curso curso = cursoRepository.findById(new ObjectId(cursoId)).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Horario horario = horarioRepository.findById(new ObjectId(horarioId)).orElseThrow(() -> new RuntimeException("Horario no encontrado"));

        CursoHorario cursoHorario = new CursoHorario();
        cursoHorario.curso = curso;
        cursoHorario.horario = horario;

        return cursoHorarioRepository.save(cursoHorario);
    }

    public List<CursoHorario> obtenerCursoHorarios() {
        return cursoHorarioRepository.findAll();
    }

    public CursoHorario obtenerCursoHorarioPorId(String id) {
        return cursoHorarioRepository.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("CursoHorario no encontrado"));
    }
}
