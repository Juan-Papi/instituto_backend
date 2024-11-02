package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UsuarioGraphQL {

    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAuthority('READ_USERS')")
    @QueryMapping
    public List<Usuario> usuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PreAuthorize("hasAuthority('CREATE_USERS')")
    @MutationMapping
    public Usuario crearUsuario(@Argument String username, @Argument String password, @Argument List<String> roles) {
        return usuarioService.crearUsuario(username, password, roles);
    }
}
