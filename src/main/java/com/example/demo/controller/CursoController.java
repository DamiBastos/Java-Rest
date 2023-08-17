package com.example.demo.controller;

import com.example.demo.dto.CursoDTO;
import com.example.demo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired CursoService cursoService;

    @PostMapping
    public CursoDTO save(@RequestBody CursoDTO cursoDTO){
        return cursoService.saveCurso(cursoDTO);
    }
}
