package com.uagrm.instituto_backend.services;

import com.uagrm.instituto_backend.entities.Curso;
import com.uagrm.instituto_backend.entities.Examen;
import com.uagrm.instituto_backend.entities.Usuario;
import com.uagrm.instituto_backend.repositories.CursoRepository;
import com.uagrm.instituto_backend.repositories.ExamenRepository;
import com.uagrm.instituto_backend.repositories.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Examen crearExamen(String tema, String descripcion, String fecha, int ponderacion, String cursoId, String profesorId) {
        Curso curso = cursoRepository.findById(new ObjectId(cursoId)).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Usuario profesor = usuarioRepository.findById(new ObjectId(profesorId)).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Examen examen = new Examen();
        examen.tema = tema;
        examen.descripcion = descripcion;
        examen.fecha = LocalDate.parse(fecha);
        examen.ponderacion = ponderacion;
        examen.curso = curso;
        examen.profesor = profesor;

        return examenRepository.save(examen);
    }

    public List<Examen> obtenerExamenes() {
        return examenRepository.findAll();
    }

    public Examen obtenerExamenPorId(String id) {
        return examenRepository.findById(new ObjectId(id)).orElseThrow(() -> new RuntimeException("Examen no encontrado"));
    }
}
