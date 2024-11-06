package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.DetalleAsistencia;
import com.uagrm.instituto_backend.services.DetalleAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class DetalleAsistenciaGraphQL {

    @Autowired
    private DetalleAsistenciaService detalleAsistenciaService;

    @MutationMapping
    public DetalleAsistencia crearDetalleAsistencia(@Argument String hora, @Argument String estudianteId, @Argument String asistenciaId) {
        return detalleAsistenciaService.crearDetalleAsistencia(hora, estudianteId, asistenciaId);
    }

    @QueryMapping
    public List<DetalleAsistencia> detallesAsistencia() {
        return detalleAsistenciaService.obtenerDetallesAsistencia();
    }

    @QueryMapping
    public DetalleAsistencia detalleAsistenciaPorId(@Argument String id) {
        return detalleAsistenciaService.obtenerDetalleAsistenciaPorId(id);
    }
}

