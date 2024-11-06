package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.DetalleCalificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleCalificacionRepository extends MongoRepository<DetalleCalificacion, String> {
    // Métodos adicionales de consulta si es necesario
}
