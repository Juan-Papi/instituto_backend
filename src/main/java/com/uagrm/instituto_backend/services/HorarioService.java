package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Horario;
import com.uagrm.instituto_backend.repositories.HorarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public Horario crearHorario(String dia, String horaInicio, String horaFinal) {
        Horario horario = new Horario();
        horario.dia = dia;
        horario.horaInicio = LocalDateTime.parse(horaInicio);
        horario.horaFinal = LocalDateTime.parse(horaFinal);
        return horarioRepository.save(horario);
    }

    public List<Horario> obtenerHorarios() {
        return horarioRepository.findAll();
    }

    public Horario obtenerHorarioPorId(String id) {
        return horarioRepository.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Horario no encontrado"));
    }
}
