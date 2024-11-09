package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Calificacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalificacionRepository extends MongoRepository<Calificacion, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}
