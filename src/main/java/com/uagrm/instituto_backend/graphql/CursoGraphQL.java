package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Curso;
import com.uagrm.instituto_backend.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class CursoGraphQL {

    @Autowired
    private CursoService cursoService;

    @MutationMapping
    public Curso crearCurso(@Argument String nombre, @Argument String descripcion, @Argument String fechaInicio, @Argument String fechaFinal, @Argument float precio, @Argument String profesorId) {
        return cursoService.crearCurso(nombre, descripcion, fechaInicio, fechaFinal, precio, profesorId);
    }

    @QueryMapping
    public List<Curso> cursos() {
        return cursoService.obtenerCursos();
    }

    @QueryMapping
    public Curso cursoPorId(@Argument String id) {
        return cursoService.obtenerCursoPorId(id);
    }
}
