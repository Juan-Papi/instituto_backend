package com.uagrm.instituto_backend.config;

import com.uagrm.instituto_backend.entities.Permiso;
import com.uagrm.instituto_backend.entities.Rol;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        for (Rol rol : usuario.roles) {
            // Añadir el rol con el prefijo "ROLE_"
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.nombre));

            // Añadir los permisos asociados al rol
            for (Permiso permiso : rol.permisos) {
                authorities.add(new SimpleGrantedAuthority(permiso.nombre));
            }
        }
        return new User(
                usuario.username,
                usuario.password,
                authorities
        );
    }
}