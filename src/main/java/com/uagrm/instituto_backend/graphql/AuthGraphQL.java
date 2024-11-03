package com.uagrm.instituto_backend.graphql;

import com.uagrm.instituto_backend.entities.AuthData;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.services.UsuarioService;
import com.uagrm.instituto_backend.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class AuthGraphQL {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @MutationMapping
    public AuthData login(@Argument String username, @Argument String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Usuario usuario = usuarioService.obtenerPorUsername(userDetails.getUsername());

        String token = jwtTokenUtil.generateToken(usuario);

        return new AuthData(token, usuario);
    }

    @QueryMapping
    public Usuario checkAuthStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName();
            return usuarioService.obtenerPorUsername(username);
        }
        return null;
    }

}
