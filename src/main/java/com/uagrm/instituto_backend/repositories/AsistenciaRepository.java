package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Asistencia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsistenciaRepository extends MongoRepository<Asistencia, String> {
    // Métodos adicionales de consulta si es necesario
}
