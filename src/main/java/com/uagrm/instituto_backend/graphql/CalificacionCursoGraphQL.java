package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.CalificacionCurso;
import com.uagrm.instituto_backend.services.CalificacionCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class CalificacionCursoGraphQL {

    @Autowired
    private CalificacionCursoService calificacionCursoService;

    @MutationMapping
    public CalificacionCurso crearCalificacionCurso(@Argument String fecha, @Argument String hora, @Argument String cursoId) {
        return calificacionCursoService.crearCalificacionCurso(fecha, hora, cursoId);
    }

    @QueryMapping
    public List<CalificacionCurso> calificacionesCurso() {
        return calificacionCursoService.obtenerCalificacionesCurso();
    }

    @QueryMapping
    public CalificacionCurso calificacionCursoPorId(@Argument String id) {
        return calificacionCursoService.obtenerCalificacionCursoPorId(id);
    }
}
