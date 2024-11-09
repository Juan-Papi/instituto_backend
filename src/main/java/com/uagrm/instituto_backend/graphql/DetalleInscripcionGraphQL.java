package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.DetalleInscripcion;
import com.uagrm.instituto_backend.services.DetalleInscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class DetalleInscripcionGraphQL {

    @Autowired
    private DetalleInscripcionService detalleInscripcionService;

    @MutationMapping
    public DetalleInscripcion crearDetalleInscripcion(@Argument String boletaInscripcionId, @Argument String cursoId) {
        return detalleInscripcionService.crearDetalleInscripcion(boletaInscripcionId, cursoId);
    }

    @QueryMapping
    public List<DetalleInscripcion> detallesInscripcion() {
        return detalleInscripcionService.obtenerDetallesInscripcion();
    }

    @QueryMapping
    public DetalleInscripcion detalleInscripcionPorId(@Argument String id) {
        return detalleInscripcionService.obtenerDetalleInscripcionPorId(id);
    }
}
