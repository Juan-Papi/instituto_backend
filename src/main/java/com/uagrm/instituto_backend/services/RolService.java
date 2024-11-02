package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Permiso;
import com.uagrm.instituto_backend.entities.Rol;
import com.uagrm.instituto_backend.repositories.PermisoRepository;
import com.uagrm.instituto_backend.repositories.RolRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RolService {

    private final RolRepository rolRepository;
    private final PermisoRepository permisoRepository;

    public RolService(RolRepository rolRepository, PermisoRepository permisoRepository) {
        this.rolRepository = rolRepository;
        this.permisoRepository = permisoRepository;
    }

    public Rol crearRol(String nombre, List<String> nombresPermisos) {
        Set<Permiso> permisos = new HashSet<>();
        for (String nombrePermiso : nombresPermisos) {
            Permiso permiso = permisoRepository.findByNombre(nombrePermiso);
            if (permiso != null) {
                permisos.add(permiso);
            }
        }
        Rol rol = new Rol();
        rol.nombre = nombre;
        rol.permisos = permisos;
        return rolRepository.save(rol);
    }

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }
}