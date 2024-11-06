package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.DetalleCalificacion;
import com.uagrm.instituto_backend.services.DetalleCalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DetalleCalificacionGraphQL {

    @Autowired
    private DetalleCalificacionService detalleCalificacionService;

    @MutationMapping
    public DetalleCalificacion crearDetalleCalificacion(@Argument float calificacion, @Argument String calificacionCursoId, @Argument String estudianteId) {
        return detalleCalificacionService.crearDetalleCalificacion(calificacion, calificacionCursoId, estudianteId);
    }

    @QueryMapping
    public List<DetalleCalificacion> detallesCalificacion() {
        return detalleCalificacionService.obtenerDetallesCalificacion();
    }

    @QueryMapping
    public DetalleCalificacion detalleCalificacionPorId(@Argument String id) {
        return detalleCalificacionService.obtenerDetalleCalificacionPorId(id);
    }
}

