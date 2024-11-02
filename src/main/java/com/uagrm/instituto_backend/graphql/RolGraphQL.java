package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Rol;
import com.uagrm.instituto_backend.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class RolGraphQL {

    @Autowired
    private RolService rolService;

    @PreAuthorize("hasAuthority('CREATE_ROLES')")
    @MutationMapping
    public Rol crearRol(@Argument String nombre, @Argument List<String> permisos) {
        return rolService.crearRol(nombre, permisos);
    }

    // Si tienes consultas (queries) relacionadas con Rol
    @PreAuthorize("hasAuthority('READ_ROLES')")
    @QueryMapping
    public List<Rol> roles() {
        return rolService.obtenerTodosLosRoles();
    }
}
