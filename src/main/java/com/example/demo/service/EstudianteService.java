package com.example.demo.service;

import com.example.demo.domain.Estudiante;
import com.example.demo.dto.EstudianteDTO;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    public EstudianteDTO saveEstudiante(EstudianteDTO estudianteDTO){
        Estudiante estudiante = new Estudiante(
                estudianteDTO.getId(),
                estudianteDTO.getNombre(),
                estudianteDTO.getApellido(),
                estudianteDTO.getEmail(),
                estudianteDTO.getDni(),
                estudianteDTO.getFechaDeNacimiento(),
                estudianteDTO.getEdad()

        );

        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }

    public List<EstudianteDTO> findAll(){
        return estudianteRepository.findAll()
                .stream().map(c -> new EstudianteDTO(c.getId(),c.getNombre(), c.getApellido(), c.getEmail(), c.getDni(), c.getFechaDeNacimiento(), c.getEdad()))
                .collect(Collectors.toList());
    }

    public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO){
        Estudiante estudiante = new Estudiante(id, estudianteDTO.getNombre(), estudianteDTO.getApellido(), estudianteDTO.getEmail(), estudianteDTO.getDni(), estudianteDTO.getFechaDeNacimiento(), estudianteDTO.getEdad());

        estudianteRepository.save(estudiante);

        return estudianteDTO;
    }

    public EstudianteDTO find(Long id){
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);

        if(estudianteOptional.isEmpty()){
            throw  new RuntimeException("Id invalido");
        }

        Estudiante estudiante = estudianteOptional.get();

        return new EstudianteDTO(estudiante.getId(),estudiante.getNombre(), estudiante.getApellido(), estudiante.getEmail(), estudiante.getDni(), estudiante.getFechaDeNacimiento(), estudiante.getEdad());
    }

    public void delete(Long id) { estudianteRepository.deleteById(id);}

}
