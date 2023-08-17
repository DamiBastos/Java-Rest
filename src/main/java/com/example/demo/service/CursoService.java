package com.example.demo.service;

import com.example.demo.domain.Curso;
import com.example.demo.dto.CursoDTO;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public CursoDTO saveCurso(CursoDTO cursoDTO){
        Curso curso = new Curso(
                cursoDTO.getId(),
                cursoDTO.getNombre(),
                cursoDTO.getDescripcion(),
                cursoDTO.getFechaDeInicio(),
                cursoDTO.getFechaDeFin()
        );

        cursoRepository.save(curso);
        return cursoDTO;
    }
}
