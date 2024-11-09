package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.DetalleCalificacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleCalificacionRepository extends MongoRepository<DetalleCalificacion, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}
