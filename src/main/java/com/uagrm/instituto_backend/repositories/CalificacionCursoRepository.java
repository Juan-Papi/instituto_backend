package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.CalificacionCurso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalificacionCursoRepository extends MongoRepository<CalificacionCurso, String> {
    // Métodos adicionales de consulta si es necesario
}
