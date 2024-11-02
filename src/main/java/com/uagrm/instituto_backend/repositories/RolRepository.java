package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolRepository extends MongoRepository<Rol, String> {
    Rol findByNombre(String nombre);
}