package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Horario;
import com.uagrm.instituto_backend.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public Horario crearHorario(String dia, Date horaInicio, Date horaFinal) {
        Horario horario = new Horario();
        horario.dia = dia;
        horario.horaInicio = horaInicio;
        horario.horaFinal = horaFinal;
        return horarioRepository.save(horario);
    }

    public List<Horario> obtenerHorarios() {
        return horarioRepository.findAll();
    }

    public Horario obtenerHorarioPorId(String id) {
        return horarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Horario no encontrado"));
    }
}
