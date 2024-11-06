package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Asistencia;
import com.uagrm.instituto_backend.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class AsistenciaGraphQL {

    @Autowired
    private AsistenciaService asistenciaService;

    @MutationMapping
    public Asistencia crearAsistencia(@Argument Date fecha, @Argument Date horaInicio, @Argument Date horaFinal, @Argument String docenteId, @Argument String cursoHorarioId) {
        return asistenciaService.crearAsistencia(fecha, horaInicio, horaFinal, docenteId, cursoHorarioId);
    }

    @QueryMapping
    public List<Asistencia> asistencias() {
        return asistenciaService.obtenerAsistencias();
    }

    @QueryMapping
    public Asistencia asistenciaPorId(@Argument String id) {
        return asistenciaService.obtenerAsistenciaPorId(id);
    }
}

