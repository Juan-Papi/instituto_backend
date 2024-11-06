package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Examen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExamenRepository extends MongoRepository<Examen, String> {
    // Métodos adicionales de consulta si es necesario
}
