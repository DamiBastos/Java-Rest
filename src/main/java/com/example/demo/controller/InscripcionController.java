package com.example.demo.controller;

import com.example.demo.dto.InscripcionDTO;
import com.example.demo.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public InscripcionDTO save(@RequestBody InscripcionDTO inscripcionDTO){
        return inscripcionService.saveInscripcion(inscripcionDTO);
    }

}
