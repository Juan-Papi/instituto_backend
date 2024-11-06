package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.BoletaInscripcion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoletaInscripcionRepository extends MongoRepository<BoletaInscripcion, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}
