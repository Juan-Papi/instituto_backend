package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Calificacion;
import com.uagrm.instituto_backend.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CalificacionGraphQL {

    @Autowired
    private CalificacionService calificacionService;

    @MutationMapping
    public Calificacion crearCalificacion(@Argument int nota, @Argument String estudianteId, @Argument String examenId) {
        return calificacionService.crearCalificacion(nota, estudianteId, examenId);
    }

    @QueryMapping
    public List<Calificacion> calificaciones() {
        return calificacionService.obtenerCalificaciones();
    }

    @QueryMapping
    public Calificacion calificacionPorId(@Argument String id) {
        return calificacionService.obtenerCalificacionPorId(id);
    }
}
