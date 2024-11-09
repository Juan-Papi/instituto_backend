package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.CursoHorario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoHorarioRepository extends MongoRepository<CursoHorario, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}
