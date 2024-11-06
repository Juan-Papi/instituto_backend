package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.BoletaInscripcion;
import com.uagrm.instituto_backend.services.BoletaInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class BoletaInscripcionGraphQL {

    @Autowired
    private BoletaInscripcionService boletaInscripcionService;

    @MutationMapping
    public BoletaInscripcion crearBoletaInscripcion(@Argument String fecha, @Argument float montoTotal, @Argument String administradorId, @Argument String estudianteId) {
        return boletaInscripcionService.crearBoletaInscripcion(fecha, montoTotal, administradorId, estudianteId);
    }

    @QueryMapping
    public List<BoletaInscripcion> boletasInscripcion() {
        return boletaInscripcionService.obtenerBoletasInscripcion();
    }

    @QueryMapping
    public BoletaInscripcion boletaInscripcionPorId(@Argument String id) {
        return boletaInscripcionService.obtenerBoletaInscripcionPorId(id);
    }
}
