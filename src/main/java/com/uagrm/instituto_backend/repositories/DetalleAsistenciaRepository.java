package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.DetalleAsistencia;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetalleAsistenciaRepository extends MongoRepository<DetalleAsistencia, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}
