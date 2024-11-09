package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.CursoHorario;
import com.uagrm.instituto_backend.services.CursoHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class CursoHorarioGraphQL {

    @Autowired
    private CursoHorarioService cursoHorarioService;

    @MutationMapping
    public CursoHorario crearCursoHorario(@Argument String cursoId, @Argument String horarioId) {
        return cursoHorarioService.crearCursoHorario(cursoId, horarioId);
    }

    @QueryMapping
    public List<CursoHorario> cursoHorarios() {
        return cursoHorarioService.obtenerCursoHorarios();
    }

    @QueryMapping
    public CursoHorario cursoHorarioPorId(@Argument String id) {
        return cursoHorarioService.obtenerCursoHorarioPorId(id);
    }
}
