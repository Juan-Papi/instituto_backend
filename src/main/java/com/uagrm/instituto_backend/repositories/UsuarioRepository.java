package com.uagrm.instituto_backend.repositories;

import com.uagrm.instituto_backend.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByUsername(String username);
}