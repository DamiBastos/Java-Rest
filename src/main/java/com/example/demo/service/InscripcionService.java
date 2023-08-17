package com.example.demo.service;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.dto.InscripcionDTO;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Validated
public class InscripcionService {

    @Autowired
    InscripcionRepository inscripcionRepository;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    CursoRepository cursoRepository;
    @Transactional
    public void crearInscripcion(Estado estado, LocalDate date, @NotNull @Positive(message = "El id no puede ser negativo") Long estudianteId, @NotNull @Positive(message = "El id no puede ser negativo") Long cursoId, Estudiante estudiante, Curso curso ){


        Estudiante estudianteA= estudianteRepository
                .findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("El id del estudiante no es válido"));

        if(!estudiante.esMayorEdad()){
            System.out.println(estudiante.getEdad());
           throw  new RuntimeException("El estudiante no es mayor de edad");
        }

        Curso cursoA= cursoRepository
                .findById(cursoId)
                .orElseThrow(() -> new RuntimeException("El id del estudiante no es válido"));

        Inscripcion inscripcion = new Inscripcion(
                null,
                date,
                estado,
                estudiante,
                curso
        );

        inscripcionRepository.save(inscripcion);
    }
    public InscripcionDTO saveInscripcion(InscripcionDTO inscripcionDTO){

        Inscripcion inscripcion = new Inscripcion(
        inscripcionDTO.getId(),
        inscripcionDTO.getFechaDeInscripcion(),
        inscripcionDTO.getEstado(),
        inscripcionDTO.getEstudiante(),
        inscripcionDTO.getCurso()
        );

        inscripcionRepository.save(inscripcion);
        return inscripcionDTO;
    }
}
