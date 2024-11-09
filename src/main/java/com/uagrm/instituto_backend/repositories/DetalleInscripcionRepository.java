package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.DetalleInscripcion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleInscripcionRepository extends MongoRepository<DetalleInscripcion, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}
