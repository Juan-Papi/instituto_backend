package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Examen;
import com.uagrm.instituto_backend.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.util.List;

@Controller
public class ExamenGraphQL {

    @Autowired
    private ExamenService examenService;

    @MutationMapping
    public Examen crearExamen(@Argument String tema, @Argument String descripcion, @Argument String fecha, @Argument int ponderacion, @Argument String cursoId, @Argument String profesorId) {
        return examenService.crearExamen(tema, descripcion, fecha, ponderacion, cursoId, profesorId);
    }

    @QueryMapping
    public List<Examen> examenes() {
        return examenService.obtenerExamenes();
    }

    @QueryMapping
    public Examen examenPorId(@Argument String id) {
        return examenService.obtenerExamenPorId(id);
    }
}
