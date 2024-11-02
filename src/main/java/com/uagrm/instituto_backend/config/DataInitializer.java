package com.uagrm.instituto_backend.config;

import com.uagrm.instituto_backend.entities.Permiso;
import com.uagrm.instituto_backend.entities.Rol;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.PermisoRepository;
import com.uagrm.instituto_backend.repositories.RolRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PermisoRepository permisoRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Limpia las colecciones (opcional)
        permisoRepository.deleteAll();
        rolRepository.deleteAll();
        usuarioRepository.deleteAll();

        // Crear permisos
        Permiso permisoLeerUsuarios = new Permiso();
        permisoLeerUsuarios.nombre = "READ_USERS";

        Permiso permisoCrearUsuarios = new Permiso();
        permisoCrearUsuarios.nombre = "CREATE_USERS";

        Permiso permisoCrearRoles = new Permiso();
        permisoCrearRoles.nombre = "CREATE_ROLES";

        Permiso permisoCrearPermisos = new Permiso();
        permisoCrearPermisos.nombre = "CREATE_PERMISSIONS";

        permisoRepository.saveAll(Arrays.asList(permisoLeerUsuarios, permisoCrearUsuarios, permisoCrearRoles, permisoCrearPermisos));

        // Crear rol ADMIN con permisos
        Rol rolAdmin = new Rol();
        rolAdmin.nombre = "ADMIN";
        rolAdmin.permisos = (new HashSet<>(Arrays.asList(permisoLeerUsuarios, permisoCrearUsuarios, permisoCrearRoles, permisoCrearPermisos)));
        rolRepository.save(rolAdmin);

        // Crear usuario administrador
        Usuario admin = new Usuario();
        admin.username = "admin";
        admin.password = (passwordEncoder.encode("admin")); // Hashear la contraseña
        admin.roles = (new HashSet<>(Collections.singletonList(rolAdmin)));
        usuarioRepository.save(admin);
    }
}
