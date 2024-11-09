package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Horario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioRepository extends MongoRepository<Horario, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}
