package com.example.demo;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import com.example.demo.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Autowired
	EstudianteRepository estudianteRepository;
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	InscripcionRepository inscripcionRepository;

	@Autowired
	InscripcionService inscripcionService;
	@Bean
	public CommandLineRunner commandLineRunner (ApplicationContext ctx){
		return args -> {
			System.out.println("La aplicación ha iniciado");

			Estudiante estudiante1 = new Estudiante(
					null,
					"Carlos",
					"Romero",
					"mail@mail.com",
					15000367,
					LocalDate.of(1981, 12, 14),
					41
			);
			Estudiante estudiante2 = new Estudiante(
					null,
					"Juan",
					"Romero",
					"mail@mail.com",
					25000367,
					LocalDate.of(1988, 4, 1),
					35
			);
			Estudiante estudiante3 = new Estudiante(
					null,
					"Pepe",
					"Perez",
					"mail@mail.com",
					35000367,
					LocalDate.of(1991, 10, 20),
					31
			);

			estudianteRepository.saveAndFlush(estudiante1);
			estudianteRepository.saveAndFlush(estudiante2);
			estudianteRepository.saveAndFlush(estudiante3);

			Curso curso1 = new Curso(
					null,
					"Poesia",
					"Bases infalibles de la poesia",
					LocalDate.of(2023, 2, 13),
					LocalDate.of(2023, 2, 14)
			);

			Curso curso2 = new Curso(
					null,
					"Matematica",
					"Bases infalibles de la matematica",
					LocalDate.of(2023, 3, 13),
					LocalDate.of(2030, 12, 25)
			);

			Curso curso3 = new Curso(
					null,
					"Programacion",
					"Bases infalibles de la programacion",
					LocalDate.of(2023, 4, 13),
					LocalDate.of(2023, 11, 14)
			);

			cursoRepository.saveAndFlush(curso1);
			cursoRepository.saveAndFlush(curso2);
			cursoRepository.saveAndFlush(curso3);


			Inscripcion inscripcion1 = new Inscripcion(
					null,
					LocalDate.of(2023, 01,10),
					Estado.PROCESANDO,
					estudiante1,
					curso1
			);

			Inscripcion inscripcion2 = new Inscripcion(
					null,
					LocalDate.of(2023, 01,10),
					Estado.DENEGADO,
					estudiante1,
					curso2
			);

			Inscripcion inscripcion3 = new Inscripcion(
					null,
					LocalDate.of(2023, 01,10),
					Estado.ACEPTADO,
					estudiante2,
					curso3
			);

			inscripcionRepository.saveAndFlush(inscripcion1);
			inscripcionRepository.saveAndFlush(inscripcion2);
			inscripcionRepository.saveAndFlush(inscripcion3);

			inscripcionService.crearInscripcion(
					Estado.ACEPTADO,
					LocalDate.of(2023, 01,20),
					1L,
					1L,
					estudiante1,
					curso1
			);

			estudianteRepository.findAll(PageRequest.of(1,5, Sort.by(Sort.Direction.ASC, "dni")));
			estudianteRepository.findAll(PageRequest.of(0,2, Sort.by(Sort.Direction.ASC, "dni")));

		};
	}

}
