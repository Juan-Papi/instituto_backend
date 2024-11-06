package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Horario;
import com.uagrm.instituto_backend.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class HorarioGraphQL {

    @Autowired
    private HorarioService horarioService;

    @MutationMapping
    public Horario crearHorario(@Argument String dia, @Argument String horaInicio, @Argument String horaFinal) {
        return horarioService.crearHorario(dia, horaInicio, horaFinal);
    }

    @QueryMapping
    public List<Horario> horarios() {
        return horarioService.obtenerHorarios();
    }

    @QueryMapping
    public Horario horarioPorId(@Argument String id) {
        return horarioService.obtenerHorarioPorId(id);
    }
}
