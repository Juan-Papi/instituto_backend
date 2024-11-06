package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Curso;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.CursoRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Curso crearCurso(String nombre, String descripcion, Date fechaInicio, Date fechaFinal, float precio, String profesorId) {
        Usuario profesor = usuarioRepository.findById(new ObjectId(profesorId)).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Curso curso = new Curso();
        curso.nombre = nombre;
        curso.descripcion = descripcion;
        curso.fechaInicio = fechaInicio;
        curso.fechaFinal = fechaFinal;
        curso.precio = precio;
        curso.profesor = profesor;

        return cursoRepository.save(curso);
    }

    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCursoPorId(String id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
}
