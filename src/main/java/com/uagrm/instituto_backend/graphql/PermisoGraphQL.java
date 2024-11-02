package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Permiso;
import com.uagrm.instituto_backend.services.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PermisoGraphQL {

    @Autowired
    private PermisoService permisoService;

    @PreAuthorize("hasAuthority('CREATE_PERMISSIONS')")
    @MutationMapping
    public Permiso crearPermiso(@Argument String nombre) {
        return permisoService.crearPermiso(nombre);
    }

    @PreAuthorize("hasAuthority('READ_PERMISSIONS')")
    @QueryMapping
    public List<Permiso> permisos() {
        return permisoService.obtenerTodosLosPermisos();
    }
}
