package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Permiso;
import com.uagrm.instituto_backend.repositories.PermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    private final PermisoRepository permisoRepository;

    public PermisoService(PermisoRepository permisoRepository) {
        this.permisoRepository = permisoRepository;
    }

    public Permiso crearPermiso(String nombre) {
        Permiso permiso = new Permiso();
        permiso.nombre = nombre;
        return permisoRepository.save(permiso);
    }

    public List<Permiso> obtenerTodosLosPermisos() {
        return permisoRepository.findAll();
    }
}