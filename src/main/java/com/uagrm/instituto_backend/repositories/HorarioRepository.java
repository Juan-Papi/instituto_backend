package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioRepository extends MongoRepository<Horario, String> {
    // Métodos adicionales de consulta si es necesario
}
