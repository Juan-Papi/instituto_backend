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

        Permiso permisoCrearInscripcion = new Permiso();
        permisoCrearInscripcion.nombre = "CREATE_INSCRIPCIONS";

        Permiso permisoLeerAsistencias = new Permiso();
        permisoLeerAsistencias.nombre = "READ_ASISTENCIAS";

        Permiso permisoMarcarAsistencias = new Permiso();
        permisoMarcarAsistencias.nombre = "MARCAR_ASISTENCIAS";

        Permiso permisoCrearExamenes = new Permiso();
        permisoCrearExamenes.nombre = "CREAR_EXAMENES";

        Permiso permisoLeerExamenes = new Permiso();
        permisoLeerExamenes.nombre = "LEER_EXAMENES";

        Permiso permisoCrearPeriodoAsistencia = new Permiso();
        permisoCrearPeriodoAsistencia.nombre = "CREATE_ASISTENCIAS";

        permisoRepository.saveAll(Arrays.asList(permisoLeerUsuarios, permisoCrearUsuarios, permisoCrearRoles, permisoCrearPermisos, permisoCrearInscripcion, permisoLeerAsistencias, permisoLeerExamenes, permisoMarcarAsistencias, permisoCrearPeriodoAsistencia, permisoCrearExamenes));

        // Crear rol ADMIN con permisos
        Rol rolAdmin = new Rol();
        rolAdmin.nombre = "ADMIN";
        rolAdmin.permisos = (new HashSet<>(Arrays.asList(permisoLeerUsuarios, permisoCrearUsuarios, permisoCrearRoles, permisoCrearPermisos)));
        rolRepository.save(rolAdmin);

        // Crear rol PROFESOR con permisos
        Rol rolProfesor = new Rol();
        rolProfesor.nombre = "PROFESOR";
        rolProfesor.permisos = (new HashSet<>(Arrays.asList(permisoCrearExamenes, permisoLeerExamenes,permisoCrearPeriodoAsistencia)));
        rolRepository.save(rolProfesor);

        // Crear rol ESTUDIANTE con permisos
        Rol rolEstudiante = new Rol();
        rolEstudiante.nombre = "ESTUDIANTE";
        rolEstudiante.permisos = (new HashSet<>(Arrays.asList(permisoMarcarAsistencias, permisoLeerAsistencias, permisoLeerExamenes)));
        rolRepository.save(rolEstudiante);


        // Crear usuario administrador
        Usuario admin = new Usuario();
        admin.username = "admin@gmail.com";
        admin.password = (passwordEncoder.encode("admin")); // Hashear la contraseña
        admin.roles = (new HashSet<>(Collections.singletonList(rolAdmin)));
        usuarioRepository.save(admin);

        // Crear usuario profesor
        Usuario profesor = new Usuario();
        profesor.username = "profesor@gmail.com";
        profesor.password = (passwordEncoder.encode("profesor")); // Hashear la contraseña
        profesor.roles = (new HashSet<>(Collections.singletonList(rolProfesor)));
        usuarioRepository.save(profesor);

        // Crear usuario administrador
        Usuario estudiante = new Usuario();
        estudiante.username = "estudiante@gmail.com";
        estudiante.password = (passwordEncoder.encode("estudiante")); // Hashear la contraseña
        estudiante.roles = (new HashSet<>(Collections.singletonList(rolEstudiante)));
        usuarioRepository.save(estudiante);
    }
}
