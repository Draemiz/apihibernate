package com.krakdev.apihibernate.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.apihibernate.entidades.Pelicula;
import com.krakdev.apihibernate.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	private final ServicioPelicula servicioP;

	public PeliculaController(ServicioPelicula servicioP) {

		this.servicioP = servicioP;
	}

	@PostMapping
	public Pelicula crear(@RequestBody Pelicula pelicula) {

		return servicioP.crear(pelicula);
	}

	@GetMapping
	public List<Pelicula> listar() {

		return servicioP.listar();
	}

	@GetMapping("/{id}")
	public Pelicula buscarPorId(@PathVariable Long id) {

		return servicioP.buscarPorId(id);
	}

	@PutMapping("/{id}")
	public Pelicula actualizar(@PathVariable Long id,
			@RequestBody Pelicula pelicula) {

		return servicioP.actualizar(id, pelicula);
	}

	@DeleteMapping("/{id}")
	public boolean eliminar(@PathVariable Long id) {

		return servicioP.eliminar(id);
	}

	@GetMapping("/genero/{genero}")
	public List<Pelicula> buscarPorGenero(
			@PathVariable String genero) {

		return servicioP.buscarPorGenero(genero);
	}

	@GetMapping("/disponible/{disponible}")
	public List<Pelicula> buscarPorDisponible(
			@PathVariable boolean disponible) {

		return servicioP.buscarPorDisponible(disponible);
	}

	@GetMapping("/director/{director}")
	public List<Pelicula> buscarPorDirector(
			@PathVariable String director) {

		return servicioP.buscarPorDirector(director);
	}

}
