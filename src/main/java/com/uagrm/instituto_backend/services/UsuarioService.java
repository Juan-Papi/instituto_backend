package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Rol;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.RolRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario crearUsuario(String username, String password, List<String> nombresRoles) {
        Set<Rol> roles = new HashSet<>();
        for (String nombreRol : nombresRoles) {
            Rol rol = rolRepository.findByNombre(nombreRol);
            if (rol != null) {
                roles.add(rol);
            }
        }
        Usuario usuario = new Usuario();
        usuario.username = username;
        usuario.password = passwordEncoder.encode(password);
        usuario.roles = roles;
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}