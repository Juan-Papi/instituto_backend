package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Permiso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PermisoRepository extends MongoRepository<Permiso, String> {
    Permiso findByNombre(String nombre);
}