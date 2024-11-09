package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Curso;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, ObjectId> {
    // Métodos adicionales de consulta si es necesario
}

